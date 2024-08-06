package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiMoneyTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiMoney(
                amount = 100,
                currency = "EUR",
            ),
            money,
        )
    }
}

private val money =
    """
{
   "amount": 100,
   "currency": "EUR"
}
"""
