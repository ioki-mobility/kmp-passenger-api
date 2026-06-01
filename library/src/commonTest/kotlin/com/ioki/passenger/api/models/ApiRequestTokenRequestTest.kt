package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRequestTokenRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRequestTokenRequest(
                claim = "+491601234567",
                channel = ApiVerificationChannelType.SMS,
                code = "123456",
            ),
            requestTokenRequest,
        )
    }
}

private val requestTokenRequest =
    """
{
  "claim": "+491601234567",
  "channel": "sms",
  "code": "123456"
}
"""
