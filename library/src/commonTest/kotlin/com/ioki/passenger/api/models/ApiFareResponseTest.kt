package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiFareResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiFareResponse(
                id = "far_123",
                version = 0,
                bookingPrice = ApiMoney(100, "EUR"),
                bookingPriceType = ApiFareResponse.BookingPriceType.MAX,
                finalPrice = ApiMoney(95, "EUR"),
                showCustomMessage = false,
            ),
            fare,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiFareResponse(
                id = "far_123",
                version = 0,
                bookingPrice = ApiMoney(100, "EUR"),
                bookingPriceType = ApiFareResponse.BookingPriceType.ESTIMATE,
                finalPrice = null,
                showCustomMessage = false,
            ),
            fareMinimal,
        )
    }
}

private val fare =
    """
{
  "id": "far_123",
  "version": 0,
  "booking_price": {
    "amount": 100,
    "currency": "EUR"
  },
  "booking_price_type": "max",
  "final_price":  {
    "amount": 95,
    "currency": "EUR"
  },
  "show_custom_message": false
}
"""

private val fareMinimal =
    """
{
  "id": "far_123",
  "version": 0,
  "booking_price": {
    "amount": 100,
    "currency": "EUR"
  },
  "booking_price_type": "estimate",
  "show_custom_message": false
}
"""
