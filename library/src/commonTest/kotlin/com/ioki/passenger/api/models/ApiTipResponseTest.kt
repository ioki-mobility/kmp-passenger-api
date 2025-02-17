package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiTipResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiTipResponse(
                ApiMoney(
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
  "amount": {
    "amount": 150,
    "currency": "EUR"
  }
}
"""
