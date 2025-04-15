package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiPaymentMethodRequest
import kotlin.test.Test

internal class ApiSettleDebitRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiSettleDebitRequest(
                paymentMethod = createApiPaymentMethodRequest(
                    paymentMethodType = ApiPaymentMethodType.STRIPE,
                    id = "paymentMethodId",
                ),
                paypalSecureElement = "secureElement",
            ),
            settleDebitRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiSettleDebitRequest(
                paymentMethod = createApiPaymentMethodRequest(
                    paymentMethodType = ApiPaymentMethodType.LOGPAY,
                    id = "paymentMethodId",
                ),
                paypalSecureElement = null,
            ),
            settleDebitRequestMinimal,
        )
    }
}

private val settleDebitRequest =
    """
{
  "payment_method": {
    "payment_method_type": "stripe",
    "id": "paymentMethodId"
  },
  "paypal_secure_element": "secureElement"
}
"""

private val settleDebitRequestMinimal =
    """
{
  "payment_method": {
    "payment_method_type": "logpay",
    "id": "paymentMethodId"
  },
  "paypal_secure_element": null
}
"""
