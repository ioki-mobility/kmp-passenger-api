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
                customMessageForExternalPricing = "custom_message",
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
                customMessageForExternalPricing = null,
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
  "custom_message_for_external_pricing": "custom_message"
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
  "booking_price_type": "estimate"
}
"""
