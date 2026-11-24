package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiCreatePayonePaymentMethodRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testModelCanBeConvertedToJsonString(
            apiCreatePayonePaymentMethodRequestJson,
            ApiCreatePayonePaymentMethodRequest(type = ApiPayoneType.CARD),
        )
        testJsonStringCanBeConvertedToModel(
            ApiCreatePayonePaymentMethodRequest(type = ApiPayoneType.CARD),
            apiCreatePayonePaymentMethodRequestJson,
        )
    }
}

private val apiCreatePayonePaymentMethodRequestJson =
    """
    {
      "payment_method_type": "card"
    }
    """
