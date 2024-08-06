package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiOfferedCreditPackageTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiOfferedCreditPackage(
                ApiMoney(amount = 200, currency = "EUR"),
                ApiMoney(amount = 300, currency = "EUR"),
            ),
            offeredCreditPackage,
        )
    }
}

private val offeredCreditPackage =
    """
{
  "cost": {
    "amount": 200,
    "currency": "EUR"
  },
  "value": {
    "amount": 300,
    "currency": "EUR"
  }
}
"""
