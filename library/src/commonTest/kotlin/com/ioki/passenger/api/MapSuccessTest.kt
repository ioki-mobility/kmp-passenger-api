package com.ioki.passenger.api

import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.result.Result
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class MapSuccessTest {

    private val apiClientInfoResponse = ApiClientInfoResponse(
        distributionUrl = "https://example.com/distribution",
        termsOfServiceUrl = "https://example.com/terms",
        privacyPolicyUrl = "https://example.com/privacy",
        imprintUrl = "https://example.com/imprint",
        helpUrl = "https://example.com/help",
        supportEmail = "support@example.com",
        supportWebsiteUrl = "https://example.com/support",
        supportPhoneNumber = "+1234567890",
        smsPhoneNumber = "+0987654321",
    )

    @Test
    fun `mapSuccess returns Result with ApiClientInfoResponse`() = runTest {
        val content = ByteReadChannel(
            text = """
                {
                  "data": {
                    "distribution_url": "https://example.com/distribution",
                    "terms_of_service_url": "https://example.com/terms",
                    "privacy_policy_url": "https://example.com/privacy",
                    "imprint_url": "https://example.com/imprint",
                    "help_url": "https://example.com/help",
                    "support_email": "support@example.com",
                    "support_website_url": "https://example.com/support",
                    "support_phone_number": "+1234567890",
                    "sms_support_number": "+0987654321"
                  },
                  "meta": {
                    "page": 1,
                    "last_page": true
                  }
                }
            """.trimIndent(),
        )

        val fakeHttpClient = createHttpClient(HttpStatusCode.OK, content)
        val response = fakeHttpClient.get("https://127.0.0.1")

        mapSuccess<ApiBody<ApiClientInfoResponse>, ApiClientInfoResponse>(response).let { result ->
            assertIs<Result.Success<ApiClientInfoResponse>>(result)
            assertEquals(result.data, apiClientInfoResponse)
        }
    }

    @Test
    fun `mapSuccess returns Result with ApiClientInfoResponse without ApiBody`() = runTest {
        val content = ByteReadChannel(
            text = """
                {
                  "distribution_url": "https://example.com/distribution",
                   "terms_of_service_url": "https://example.com/terms",
                   "privacy_policy_url": "https://example.com/privacy",
                   "imprint_url": "https://example.com/imprint",
                   "help_url": "https://example.com/help",
                   "support_email": "support@example.com",
                   "support_website_url": "https://example.com/support",
                   "support_phone_number": "+1234567890",
                   "sms_support_number": "+0987654321"
                }
            """.trimIndent(),
        )

        val fakeHttpClient = createHttpClient(HttpStatusCode.OK, content)
        val response = fakeHttpClient.get("https://127.0.0.1")

        mapSuccess<ApiClientInfoResponse, ApiClientInfoResponse>(response).let { result ->
            assertIs<Result.Success<ApiClientInfoResponse>>(result)
            assertEquals(result.data, apiClientInfoResponse)
        }
    }

    @Test
    fun `mapSuccess throws exception`() = runTest {
        val content = ByteReadChannel(
            text = """
                {
                  "data": null,
                  "meta": {
                    "page": 1,
                    "last_page": true
                  }
                }
            """.trimIndent(),
        )

        val fakeHttpClient = createHttpClient(HttpStatusCode.OK, content)
        val response = fakeHttpClient.get("https://127.0.0.1")

        assertFailsWith<IllegalArgumentException> {
            mapSuccess<ApiBody<ApiClientInfoResponse?>, ApiClientInfoResponse>(response)
        }
    }
}
