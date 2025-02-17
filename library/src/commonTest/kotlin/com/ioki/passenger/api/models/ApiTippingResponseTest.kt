package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiTippingResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            tipping,
            tippingJson,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            tippingMinimal,
            tippingMinimalJson,
        )
    }
}

private val tipping =
    ApiTipping(
        minimum = ApiMoney(50, "EUR"),
        maximum = ApiMoney(500, "EUR"),
        suggestions =
        listOf(
            ApiMoney(150, "EUR"),
            ApiMoney(250, "EUR"),
            ApiMoney(350, "EUR"),
        ),
    )

private val tippingMinimal =
    ApiTipping(
        minimum = ApiMoney(50, "EUR"),
        maximum = null,
        suggestions =
        listOf(
            ApiMoney(150, "EUR"),
            ApiMoney(250, "EUR"),
            ApiMoney(350, "EUR"),
        ),
    )

private val tippingJson =
    """
{
  "minimum": {
    "amount": 50,
    "currency": "EUR"
  },
  "maximum": {
    "amount": 500,
    "currency": "EUR"
  },
  "suggestions": [
    {
      "amount": 150,
      "currency": "EUR"
    },
    {
      "amount": 250,
      "currency": "EUR"
    },
    {
      "amount": 350,
     "currency": "EUR"
    }
  ]
}
"""

private val tippingMinimalJson =
    """
{
  "minimum": {
    "amount": 50,
    "currency": "EUR"
  },
  "suggestions": [
    {
      "amount": 150,
      "currency": "EUR"
    },
    {
      "amount": 250,
      "currency": "EUR"
    },
    {
      "amount": 350,
     "currency": "EUR"
    }
  ]
}
"""
