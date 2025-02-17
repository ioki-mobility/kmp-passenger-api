package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPurchasedCreditPackageResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchasedCreditPackageResponse(balance = ApiMoney(800, "EUR")),
            purchasedCreditPackage,
        )
    }
}

private val purchasedCreditPackage =
    """
{
  "balance": {
    "amount": 800,
    "currency": "EUR"
  }
}
"""
