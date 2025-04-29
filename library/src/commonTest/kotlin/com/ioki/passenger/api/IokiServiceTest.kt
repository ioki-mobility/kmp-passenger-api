package com.ioki.passenger.api

import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse
import com.ioki.passenger.api.result.Error
import com.ioki.passenger.api.result.SuccessData
import com.ioki.passenger.api.result.value
import com.ioki.result.Result
import com.ioki.result.failureOrNull
import com.ioki.result.map
import com.ioki.result.mapFailure
import com.ioki.result.successOrNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.http.HttpStatusCode
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class IokiServiceTest {

    @Test
    fun `getUser returns user successfully`() = runTest {
        val httpResult = ByteReadChannel(text = authenticatedUser)
        val iokiService = IokiService(
            accessTokenProvider = FakeAccessTokenProvider(),
            iokiHttpClient = FakeHttpClient(HttpStatusCode.OK, httpResult),
        )

        val user = iokiService.getUser()

        user.shouldBeInstanceOf<Result.Success<SuccessData<ApiAuthenticatedUserResponse>>>()
    }

    @Test
    fun `getUser returns ResultSuccess that I can map and mapFailure`() = runTest {
        val httpResult = ByteReadChannel(text = authenticatedUser)
        val iokiService = IokiService(
            accessTokenProvider = FakeAccessTokenProvider(),
            iokiHttpClient = FakeHttpClient(HttpStatusCode.OK, httpResult),
        )

        val user = iokiService.getUser()
            .map { (user, _) -> user.firstName }
            .mapFailure {
                when (it) {
                    is Error.Api.Generic -> "Generic error. Call backend for help!"
                    is Error.Api.Intercepted -> "Intercepted, don't show an error message."
                    is Error.Connectivity -> "He's Dead, Jim."
                    is Error.Generic -> "Client error? Fix me!"
                }
            }

        user.successOrNull() shouldBe "John"
    }

    @Test
    fun `getUser returns ResultSuccess`() = runTest {
        val httpResult = ByteReadChannel(text = authenticatedUser)
        val iokiService = IokiService(
            accessTokenProvider = FakeAccessTokenProvider(),
            iokiHttpClient = FakeHttpClient(HttpStatusCode.OK, httpResult),
        )

        val user = iokiService.getUser()

        when (user) {
            is Result.Failure<Error> -> error("Shouldn't be an error!")
            is Result.Success<SuccessData<ApiAuthenticatedUserResponse>> -> {
                user.value.firstName shouldBe "John"
            }
        }
    }

    @Test
    fun `getUser returns ResultFailure that I can map and mapFailure`() = runTest {
        val httpResult = ByteReadChannel.Empty
        val iokiService = IokiService(
            accessTokenProvider = FakeAccessTokenProvider(),
            iokiHttpClient = FakeHttpClient(HttpStatusCode.Unauthorized, httpResult),
        )

        val user = iokiService.getUser()
            .map { (user, _) -> user.firstName }
            .mapFailure {
                when (it) {
                    is Error.Api.Generic -> "Api error. We might got an error? ${it.errors}"
                    is Error.Api.Intercepted -> "Intercepted, don't show an error message."
                    is Error.Connectivity -> "He's Dead, Jim."
                    is Error.Generic -> "Client error? Fix me!"
                }
            }

        user.failureOrNull() shouldBe "Api error. We might got an error? []"
    }

    @Test
    fun `getUser throws HttpTimeoutException`() = runTest {
        val httpResult = ByteReadChannel.Empty
        val iokiService = IokiService(
            accessTokenProvider = FakeAccessTokenProvider(),
            iokiHttpClient = FakeHttpClient(
                statusCode = HttpStatusCode.ServiceUnavailable,
                content = httpResult,
                throws = HttpRequestTimeoutException("", null, null),
            ),
        )

        val user = iokiService.getUser()

        user.shouldBeInstanceOf<Result.Failure<Error.Connectivity>>()
    }
}

private class FakeAccessTokenProvider(override var accessToken: String? = "") : AccessTokenProvider

private val authenticatedUser = """
{
  "data": {
    "id": "abc123",
    "first_name": "John",
    "last_name": "Doe",
    "phone_number": "+4912345",
    "registered": true,
    "analytics_tracking":false,
    "email": {
      "email_address": "john.doe@deutschebahn.com",
      "newsletter": false,
      "receipt": true,
      "confirmed": true
    },
    "current_terms_accepted": true,
    "minimum_age_confirmed": true,
    "referring_user_set": true,
    "referral_code": "IAMYOURFRIEND",
    "remaining_referrals": 5,
    "version": 2,
    "allow_marketing": false,
    "logpay_customer_set": false,
    "logpay_support_details": {
      "email": "test.ioki@logpay.com",
      "subject": "Declined payment",
      "body": "Your account is suspended"
    },
    "unique_customer_id": "IOKI42",
    "additional_data": {
      "marketing_automation_push_channel_enabled": true,
      "marketing_automation_message_center_channel_enabled": false
    }
  }
}
"""
