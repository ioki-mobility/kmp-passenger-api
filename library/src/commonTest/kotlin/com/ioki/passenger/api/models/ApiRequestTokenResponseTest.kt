package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRequestTokenResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiRequestTokenResponse(
                id = "tok_6b083e2b-5c5b-4a58-b3a1-46442928989c",
                type = "request_token",
                token = "i7FvNkpoTXYC4yg_kGJV7pAFxo1aVzYJ",
                userId = "usr_d10d1636-01a3-48ea-84c7-0beab1c28df3",
            ),
            requestTokenResponse,
        )
    }
}

private val requestTokenResponse =
    """
{
  "id": "tok_6b083e2b-5c5b-4a58-b3a1-46442928989c",
  "type": "request_token",
  "token": "i7FvNkpoTXYC4yg_kGJV7pAFxo1aVzYJ",
  "user_id": "usr_d10d1636-01a3-48ea-84c7-0beab1c28df3"
}
"""
