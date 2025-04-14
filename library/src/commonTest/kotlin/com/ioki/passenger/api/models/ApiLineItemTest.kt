package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiLineItemTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiLineItem(
                position = 0,
                quantity = 2,
                description = "descriptionA",
                title = "titleA",
                amountGross = ApiMoney(amount = 20, currency = "EUR"),
                amountNet = ApiMoney(amount = 16, currency = "EUR"),
            ),
            lineItem,
        )
    }

    @Test
    fun serializationNoName() {
        testJsonStringCanBeConvertedToModel(
            ApiLineItem(
                position = 0,
                quantity = 1,
                description = null,
                title = null,
                amountGross = null,
                amountNet = null,
            ),
            lineItemMinimal,
        )
    }
}

private val lineItem =
    """
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
"""

private val lineItemMinimal =
    """
{
  "position": 0,
  "quantity": 1
}
"""
