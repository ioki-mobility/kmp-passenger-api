package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPaymentMethodCreationRequestTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiPaymentMethodCreationRequest(
                paymentMethodType = "stripe",
                details = ApiPaymentMethodCreationRequest.Details(
                    stripePaymentMethodId = null,
                    braintreeNonce = null,
                    paypalSecureElement = null,
                ),
            ),
            paymentMethodCreationRequestMinimal,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPaymentMethodCreationRequest(
                paymentMethodType = "stripe",
                details = ApiPaymentMethodCreationRequest.Details(
                    stripePaymentMethodId = "stripe_method_id",
                    braintreeNonce = "braintree_nonce",
                    paypalSecureElement = "paypal_secure_element",
                ),
            ),
            paymentMethodCreationRequest,
        )
    }
}

private val paymentMethodCreationRequestMinimal =
    """
{
  "payment_method_type": "stripe",
  "details": {
  }
}
"""

private val paymentMethodCreationRequest =
    """
{
  "payment_method_type": "stripe",
  "details": {
    "stripe_payment_method_id": "stripe_method_id",
    "braintree_nonce": "braintree_nonce",
    "paypal_secure_element": "paypal_secure_element"
  }
}
"""
