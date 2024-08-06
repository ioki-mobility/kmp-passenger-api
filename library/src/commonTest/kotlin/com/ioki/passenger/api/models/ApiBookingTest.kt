package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiBookingTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiBooking("ABC123"),
            bookingResponse,
        )
    }
}

private val bookingResponse =
    """
{
  "verification_code": "ABC123"
}
"""
