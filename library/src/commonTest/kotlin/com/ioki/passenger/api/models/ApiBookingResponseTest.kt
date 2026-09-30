package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiBookingResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiBookingResponse(id = "boo_123", verificationCode = "ABC123"),
            bookingResponse,
        )
    }
}

private val bookingResponse =
    """
{
  "id": "boo_123",
  "verification_code": "ABC123"
}
"""
