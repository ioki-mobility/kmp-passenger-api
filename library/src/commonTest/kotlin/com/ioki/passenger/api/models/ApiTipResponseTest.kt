package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiTipResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiTipResponse(
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
