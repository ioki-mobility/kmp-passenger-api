package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPaymentMethodResponseTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiPaymentMethodResponse(ApiPaymentMethodType.CASH, null, null),
            paymentMethodMinimal,
        )
    }

    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiPaymentMethodResponse(
                paymentMethodType = ApiPaymentMethodType.STRIPE,
                id = "someId",
                summary = ApiPaymentMethodResponse.Summary(
                    ApiPaymentMethodResponse.Summary.Kind.CREDIT_CARD,
                    title = "Visa (*1234)",
                    expiration = "11/20",
                    mandateUrl = null,
                ),
            ),
            jsonString = paymentMethod,
        )
    }
}

private val paymentMethodMinimal =
    """
{
  "payment_method_type": "cash"
}
"""

private val paymentMethod =
    """
{
  "payment_method_type": "stripe",
  "id": "someId",
  "summary": {
        "kind": "card",
        "title": "Visa (*1234)",
        "expiration": "11/20"
  }
}
"""
