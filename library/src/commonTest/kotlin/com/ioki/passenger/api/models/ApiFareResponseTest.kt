package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiFareResponse.LineItem
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
                lineItems = listOf(
                    LineItem(
                        position = 0,
                        quantity = 2,
                        description = "descriptionA",
                        title = "titleA",
                        amountGross = ApiMoney(amount = 20, currency = "EUR"),
                        amountNet = ApiMoney(amount = 16, currency = "EUR"),
                    ),
                ),
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
                lineItems = emptyList(),
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
  "custom_message_for_external_pricing": "custom_message",
    "line_items": [
        {
        "position": 0,
        "quantity": 2,
        "description": "descriptionA",
        "title": "titleA",
        "amount_gross": {
            "amount": 20,
            "currency": "EUR"
        },
        "amount_net": {
            "amount": 16,
            "currency": "EUR"
        }
        }
    ]
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
  "line_items": []
}
"""
