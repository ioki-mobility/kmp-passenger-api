package com.ioki.passenger.api.internal.plugins

import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

internal class HttpLoggingPluginTest {

    @Test
    fun `test http logging plugin should log information with get`() = runTest {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel("""{"ip":"127.0.0.1"}"""),
                status = HttpStatusCode.OK,
                headers = headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Date, "Sun, 06 Nov 1994 08:49:37 GMT")
                },
            )
        }
        val logText = mutableListOf<String>()
        val apiClient = HttpClient(mockEngine) {
            install(HttpLoggingPlugin) {
                logging = { logText.add(it) }
                coroutineScope = this@runTest
            }
        }

        apiClient.get("http://localhost:8080")

        advanceUntilIdle()
        val expected = mutableListOf(
            "--> GET http://localhost:8080",
            "<-- 200 http://localhost:8080",
            "Content-Type: application/json",
            "Date: Sun, 06 Nov 1994 08:49:37 GMT",
            "{\"ip\":\"127.0.0.1\"}",
        )
        logText shouldBe expected
    }

    @Test
    fun `test http logging plugin should log information with post`() = runTest {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel("""{"ip":"127.0.0.1"}"""),
                status = HttpStatusCode.OK,
                headers = headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Date, "Sun, 06 Nov 1994 08:49:37 GMT")
                },
            )
        }
        val logText = mutableListOf<String>()
        val apiClient = HttpClient(mockEngine) {
            install(HttpLoggingPlugin) {
                coroutineScope = this@runTest
                logging = { logText.add(it) }
            }
        }

        apiClient.post("http://localhost:8080") {
            setBody("""{"name":"test"}""")
        }

        advanceUntilIdle()
        val expected = mutableListOf(
            "--> POST http://localhost:8080",
            "{\"name\":\"test\"}",
            "<-- 200 http://localhost:8080",
            "Content-Type: application/json",
            "Date: Sun, 06 Nov 1994 08:49:37 GMT",
            "{\"ip\":\"127.0.0.1\"}",
        )
        logText shouldBe expected
    }
}
