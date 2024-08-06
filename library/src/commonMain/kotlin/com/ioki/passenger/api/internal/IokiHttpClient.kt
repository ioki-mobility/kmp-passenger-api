package com.ioki.passenger.api.internal

import com.ioki.passenger.api.RequestHeaders
import com.ioki.passenger.api.TimeOffsetProvider
import com.ioki.passenger.api.internal.plugins.AuthorizationPlugin
import com.ioki.passenger.api.internal.plugins.DateHeaderPlugin
import com.ioki.passenger.api.internal.plugins.HttpLoggingPlugin
import com.ioki.passenger.api.internal.utils.createJson
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json

private const val TIMEOUT_MILLISECONDS = 20 * 1000L

internal typealias IokiHttpClient = HttpClient

internal expect fun httpClient(): HttpClient

internal fun IokiHttpClient(
    baseUrl: String,
    requestHeaders: RequestHeaders,
    timeOffsetProvider: TimeOffsetProvider,
    logging: Logging?,
): IokiHttpClient = httpClient().config {
    install(ContentNegotiation) {
        json(createJson())
    }
    install(HttpTimeout) {
        requestTimeoutMillis = TIMEOUT_MILLISECONDS
        connectTimeoutMillis = TIMEOUT_MILLISECONDS
        socketTimeoutMillis = TIMEOUT_MILLISECONDS
    }
    install(AuthorizationPlugin)
    install(DateHeaderPlugin) {
        offsetProvider = timeOffsetProvider
    }
    install(HttpCache)

    if (logging != null) {
        install(HttpLoggingPlugin) {
            this.logging = logging
        }
    }

    defaultRequest {
        url(baseUrl)
        headers {
            append("Accept", "application/json")
            append("Content-Type", "application/json")
            append("Accept-Language", requestHeaders.languageTag)
            append("X-Api-Version", requestHeaders.apiVersion)
            append("X-Client-Identifier", requestHeaders.clientIdentifier)
            append("X-Client-Version", requestHeaders.clientVersion)
            append("X-Client-Secret", requestHeaders.clientSecret)
            append("X-Debug-Identifier", requestHeaders.debugIdentifier)
        }
    }
}
