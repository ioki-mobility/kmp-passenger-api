package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPurchasedCreditPackageResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchasedCreditPackageResponse(id = "svc_123", balance = ApiMoney(800, "EUR")),
            purchasedCreditPackage,
        )
    }
}

private val purchasedCreditPackage =
    """
{
  "id": "svc_123",
  "balance": {
    "amount": 800,
    "currency": "EUR"
  }
}
"""
