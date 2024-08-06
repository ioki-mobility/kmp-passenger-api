package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPhoneVerificationRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiPhoneVerificationRequest("+491601234567", null),
            verification,
        )
    }
}

private val verification =
    """
{
  "phone_number": "+491601234567"
}
"""
