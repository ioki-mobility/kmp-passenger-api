package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createPaymentMethod
import kotlin.test.Test


internal class ApiResettleDebitsRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiResettleDebitsRequest(
                purchaseIds = listOf("purchaseId1", "purchaseId2"),
                paymentMethod = createPaymentMethod(
                    paymentMethodType = ApiPaymentMethodType.POS_PAYMENT,
                    id = "paymentMethodId",
                ),
                paypalSecureElement = "secureElement",
                amount = 100,
            ),
            resettleDebitsRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiResettleDebitsRequest(
                purchaseIds = emptyList(),
                paymentMethod = createPaymentMethod(
                    paymentMethodType = ApiPaymentMethodType.LOGPAY,
                    id = "paymentMethodId",
                ),
                paypalSecureElement = null,
                amount = 0,
            ),
            resettleDebitsRequestMinimal,
        )
    }
}

private val resettleDebitsRequest =
    """
{
  "purchase_ids": [
    "purchaseId1",
    "purchaseId2"
  ],
  "payment_method": {
    "payment_method_type": "pos_payment",
    "id": "paymentMethodId"
  },
  "paypal_secure_element": "secureElement",
  "amount": 100
}
"""

private val resettleDebitsRequestMinimal =
    """
{
  "purchase_ids": [],
  "payment_method": {
    "payment_method_type": "logpay",
    "id": "paymentMethodId"
  },
  "paypal_secure_element": null,
  "amount": 0
}
"""
