package com.zjutjh.ijh.network.interceptor

import com.zjutjh.ijh.network.APIResponseException
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import java.nio.charset.Charset
import javax.inject.Inject
import kotlin.text.Charsets.UTF_8

class APIExceptionInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if (!response.isSuccessful) {
            return response
        }

        val responseBody = response.body()!!
        val source = responseBody.source()
        source.request(Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source.buffer
        val contentType = responseBody.contentType()
        val charset: Charset = contentType?.charset(UTF_8) ?: UTF_8
        val resultString = buffer.clone().readString(charset)

        val jsonObject = JSONObject(resultString)
        if (!jsonObject.has("code")) {
            return response
        }

        val code = jsonObject.optInt("code")
        // Success
        if (code == 0) {
            return response
        }

        val msg = jsonObject.optString("msg", "Undefined error message")
        throw APIResponseException(code, msg)
    }
}