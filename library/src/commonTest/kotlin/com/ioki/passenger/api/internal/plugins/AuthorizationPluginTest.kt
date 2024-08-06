package com.ioki.passenger.api.internal.plugins

import com.ioki.passenger.api.AccessTokenProvider
import com.ioki.passenger.api.internal.authorisation.createAuthHeaderProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.expect

internal class AuthorizationPluginTest {

    @Test
    fun `throw exception if user is not authenticated`() = runTest {
        val fakeAccessTokenProvider = object : AccessTokenProvider {
            override var accessToken: String? = null
        }
        val fakeAuthProvider = createAuthHeaderProvider(fakeAccessTokenProvider)

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
            install(AuthorizationPlugin)
        }
        val exception = assertFailsWith<AccessTokenUnavailableException> {
            apiClient.get("http://localhost:8080") {
                header(HttpHeaders.Authorization, fakeAuthProvider.provide())
            }
        }
        assertIs<AccessTokenUnavailableException>(exception)
    }

    @Test
    fun `no exception if user is authenticated`() = runTest {
        val fakeAccessTokenProvider = object : AccessTokenProvider {
            override var accessToken: String? = "best-token-ever"
        }
        val fakeAuthProvider = createAuthHeaderProvider(fakeAccessTokenProvider)

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
            install(AuthorizationPlugin)
        }

        val result = apiClient.get("http://localhost:8080") {
            header(HttpHeaders.Authorization, fakeAuthProvider.provide())
        }
        expect(HttpStatusCode.OK) { result.status }
    }
}
