package com.ioki.passenger.api

import com.ioki.passenger.api.internal.utils.createJson
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel

internal fun createHttpClient(
    statusCode: HttpStatusCode,
    content: ByteReadChannel,
): HttpClient {
    val mockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = statusCode,
            headers = headers {
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Date, "Sun, 06 Nov 1994 08:49:37 GMT")
            },
        )
    }

    return HttpClient(mockEngine) {
        install(ContentNegotiation) {
            json(createJson())
        }
    }
}
