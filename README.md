# IJH Android

[![Android CI](https://github.com/I-Info/IJH-Android/actions/workflows/ci.yml/badge.svg)](https://github.com/I-Info/IJH-Android/actions/workflows/ci.yml)

IJH app for Android, a **work in progress** currently.

## Features

- [ ] All features supported by **WeJH**.
- [ ] Notifications.
- [ ] More...

## Architecture

The app follows
the [official architecture guidance](https://developer.android.com/topic/architecture).

![module.png](https://s2.loli.net/2023/10/29/EUNtaGgBVqdfvJz.png)

- data (repository -> data source)
    - network (Retrofit/OkHttp)
    - datastore (Protobuf)
    - database (Room)

## UI

UI is built with [Jetpack Compose](https://developer.android.com/jetpack/compose) and follows
[Material Design 3](https://m3.material.io).

- Theme: IJH app uses the Dynamic color theme (Material You), and provides a default theme for
  fallbacks.

## Dependency injection (DI)

IJH app uses [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
to implement automatic DI in modules and layers.
