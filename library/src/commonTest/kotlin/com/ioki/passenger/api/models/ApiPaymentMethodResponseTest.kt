package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiPaymentMethodResponse
import com.ioki.passenger.api.test.models.createApiPaymentMethodResponseSummary
import kotlin.test.Test

internal class ApiPaymentMethodResponseTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            createApiPaymentMethodResponse(paymentMethodType = ApiPaymentMethodType.CASH),
            paymentMethodMinimal,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = createApiPaymentMethodResponse(
                paymentMethodType = ApiPaymentMethodType.STRIPE,
                requiresPaypalSecureElement = false,
                id = "someId",
                summary = createApiPaymentMethodResponseSummary(
                    kind = ApiPaymentMethodResponse.Summary.Kind.CREDIT_CARD,
                    wallet = ApiPaymentMethodResponse.Summary.Wallet.GOOGLE_PAY,
                    brand = ApiPaymentMethodResponse.Summary.Brand.VISA,
                    title = "Visa (*1234)",
                    last4 = "1234",
                    expiration = "11/20",
                ),
            ),
            jsonString = paymentMethod,
        )
    }
}

private val paymentMethodMinimal =
    """
{
  "payment_method_type": "cash",
  "requires_paypal_secure_element": false
}
"""

private val paymentMethod =
    """
{
  "payment_method_type": "stripe",
  "requires_paypal_secure_element": false,
  "id": "someId",
  "summary": {
        "kind": "card",
        "wallet": "google_pay",
        "brand": "visa",
        "last4": "1234",
        "title": "Visa (*1234)",
        "expiration": "11/20"
  }
}
"""
