package com.zjutjh.ijh.network.exception

import java.io.IOException

/**
 * API call exception response
 */
class ApiResponseException(val code: Int, override val message: String) : IOException()