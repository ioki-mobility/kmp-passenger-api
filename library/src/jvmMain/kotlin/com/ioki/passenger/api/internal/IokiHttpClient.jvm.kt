package com.ioki.passenger.api.internal

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun httpClient(): HttpClient = HttpClient(OkHttp)
