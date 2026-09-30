package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiTipResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiTipResponse(
                id = "tip_123",
                amount = ApiMoney(
                    amount = 150,
                    currency = "EUR",
                ),
            ),
            jsonString = createTipResult,
        )
    }
}

private val createTipResult =
    """
{
  "id": "tip_123",
  "amount": {
    "amount": 150,
    "currency": "EUR"
  }
}
"""
