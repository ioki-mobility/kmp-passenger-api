package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRequestTokenRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRequestTokenRequest("+491601234567", "123456"),
            requestTokenRequest,
        )
    }
}

private val requestTokenRequest =
    """
{
  "phone_number": "+491601234567",
  "code": "123456"
}
"""
