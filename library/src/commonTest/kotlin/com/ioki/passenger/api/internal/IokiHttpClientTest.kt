package com.ioki.passenger.api.internal

import com.ioki.passenger.api.AccessTokenProvider
import com.ioki.passenger.api.RequestHeaders
import com.ioki.passenger.api.TimeOffsetProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDateTime
import kotlin.test.Test

class IokiHttpClientTest {

    @Test
    fun name() = runTest {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel.Empty,
                status = HttpStatusCode.OK,
                headers = headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Date, "Sun, 06 Nov 1994 08:49:37 GMT")
                },
            )
        }
        val httpClient = IokiHttpClient(
            baseUrl = "https://api.ioki.com",
            requestHeaders = RequestHeaders(
                apiVersion = "1",
                clientIdentifier = "identifier",
                clientVersion = "1",
                clientSecret = "secret",
                languageTag = "en",
                debugIdentifier = "debug",
            ),
            timeOffsetProvider = object : TimeOffsetProvider {
                override fun setReferenceTime(referenceTime: LocalDateTime) {
                    // no-op
                }
            },
            logging = {},
            cachingEnabled = false,
            accessTokenProvider = object : AccessTokenProvider {
                override var accessToken: String? = "token!"
            },
            httpClient = HttpClient(mockEngine),
        )

        val get = httpClient.get("https://api.ioki.com")

        println(mockEngine.requestHistory.first().headers)
        println(get)
    }

    @Test
    fun name2() = runTest {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel.Empty,
                status = HttpStatusCode.Unauthorized,
                headers = headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Date, "Sun, 06 Nov 1994 08:49:37 GMT")
                },
            )
        }
        val httpClient = IokiHttpClient(
            baseUrl = "https://api.ioki.com",
            requestHeaders = RequestHeaders(
                apiVersion = "1",
                clientIdentifier = "identifier",
                clientVersion = "1",
                clientSecret = "secret",
                languageTag = "en",
                debugIdentifier = "debug",
            ),
            timeOffsetProvider = object : TimeOffsetProvider {
                override fun setReferenceTime(referenceTime: LocalDateTime) {
                    // no-op
                }
            },
            logging = {},
            cachingEnabled = false,
            accessTokenProvider = object : AccessTokenProvider {
                override var accessToken: String? = null
            },
            httpClient = HttpClient(mockEngine),
        )

        val get = httpClient.get("https://api.ioki.com")

        println(mockEngine.requestHistory.first().headers)
        println(get)
    }
}
