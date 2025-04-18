package com.ioki.passenger.api.internal.plugins

import com.ioki.passenger.api.TimeOffsetProvider
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.test.Test

internal class DateHeaderPluginTest {

    @Test
    fun `test date header plugin should set correct local date time`() = runTest {
        var receivedTime: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC)
        val timeOffSetProvider = object : TimeOffsetProvider {
            override fun setReferenceTime(referenceTime: LocalDateTime) {
                receivedTime = referenceTime
            }
        }
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
        val apiClient = HttpClient(mockEngine) {
            install(DateHeaderPlugin) {
                offsetProvider = timeOffSetProvider
            }
        }

        apiClient.get("http://localhost:8080")

        val expectedLocalDateTime = LocalDateTime(1994, 11, 6, 8, 49, 37)
        receivedTime shouldBe expectedLocalDateTime
    }
}
