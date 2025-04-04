package com.ioki.passenger.api

import com.ioki.passenger.api.models.ApiErrorBody
import com.ioki.passenger.api.result.Error
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

internal class MapApiErrorTest {

    @Test
    fun `mapApiError returns version outdated error`() = runTest {
        val content = ByteReadChannel(
            text = """
                    {
                      "api_errors": [
                        { "message": "App version is outdated", "code": "version_outdated" }
                      ]
                    }
                """,
        )
        val fakeHttpClient = FakeHttpClient(HttpStatusCode.NotAcceptable, content)
        val fakeResponse = fakeHttpClient.get("https://127.0.0.1")
        val fakeApiErrorInterceptor = object : ApiErrorInterceptor {
            override fun intercept(apiErrors: List<ApiErrorBody.ApiError>, httpResponseCode: Int): Boolean {
                val isAppVersionOutdated = apiErrors.any { it.code == "version_outdated" }
                val isNotAcceptable = httpResponseCode == HttpStatusCode.NotAcceptable.value
                return isAppVersionOutdated && isNotAcceptable
            }
        }

        val result = mapApiError(fakeResponse, listOf(fakeApiErrorInterceptor))

        result.error.shouldBeInstanceOf<Error.Api.Intercepted>()
        result.error.httpStatusCode shouldBe HttpStatusCode.NotAcceptable.value
    }

    @Test
    fun `mapApiError returns unauthorized error`() = runTest {
        val content = ByteReadChannel.Empty
        val fakeHttpClient = FakeHttpClient(HttpStatusCode.Unauthorized, content)
        val fakeResponse = fakeHttpClient.get("https://127.0.0.1")
        val fakeApiErrorInterceptor = object : ApiErrorInterceptor {
            override fun intercept(apiErrors: List<ApiErrorBody.ApiError>, httpResponseCode: Int): Boolean {
                return httpResponseCode == HttpStatusCode.Unauthorized.value
            }
        }

        val result = mapApiError(fakeResponse, listOf(fakeApiErrorInterceptor))

        result.error.shouldBeInstanceOf<Error.Api.Intercepted>()
        result.error.httpStatusCode shouldBe HttpStatusCode.Unauthorized.value
    }

    @Test
    fun `mapApiError returns generic error`() = runTest {
        val content = ByteReadChannel.Empty
        val fakeHttpClient = FakeHttpClient(HttpStatusCode.BadGateway, content)
        val fakeResponse = fakeHttpClient.get("https://127.0.0.1")
        val fakeApiErrorInterceptor = object : ApiErrorInterceptor {
            override fun intercept(apiErrors: List<ApiErrorBody.ApiError>, httpResponseCode: Int): Boolean {
                return httpResponseCode == HttpStatusCode.Unauthorized.value
            }
        }

        val result = mapApiError(fakeResponse, listOf(fakeApiErrorInterceptor))

        result.error.shouldBeInstanceOf<Error.Api.Generic>()
        result.error.httpStatusCode shouldBe HttpStatusCode.BadGateway.value
    }

    @Test
    fun `mapApiError returns generic error without interceptors`() = runTest {
        val content = ByteReadChannel(
            text = """
                    {
                      "api_errors": [
                        { "message": "App version is outdated", "code": "version_outdated" }
                      ]
                    }
                """,
        )
        val fakeHttpClient = FakeHttpClient(HttpStatusCode.NotAcceptable, content)
        val fakeResponse = fakeHttpClient.get("https://127.0.0.1")

        val result = mapApiError(fakeResponse, listOf())

        result.error.shouldBeInstanceOf<Error.Api.Generic>()
        result.error.httpStatusCode shouldBe HttpStatusCode.NotAcceptable.value
    }
}
