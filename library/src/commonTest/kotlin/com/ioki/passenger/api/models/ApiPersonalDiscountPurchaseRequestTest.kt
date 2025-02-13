package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiPaymentMethodRequest
import kotlin.test.Test

internal class ApiPersonalDiscountPurchaseRequestTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            model = ApiPersonalDiscountPurchaseRequest(
                personalDiscountTypeId = "id",
                paymentMethod = createApiPaymentMethodRequest(ApiPaymentMethodType.SERVICE_CREDITS),
                paypalSecureElement = null,
                validFromDate = null,
            ),
            jsonString = personalDiscountPurchaseRequestMinimal,
        )
    }

    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiPersonalDiscountPurchaseRequest(
                personalDiscountTypeId = "id",
                paymentMethod = createApiPaymentMethodRequest(ApiPaymentMethodType.SERVICE_CREDITS),
                paypalSecureElement = "secure_element",
                validFromDate = "2024-05-15T16:33:46Z",
            ),
            personalDiscountPurchaseRequest,
        )
    }
}

private val personalDiscountPurchaseRequestMinimal =
    """
{
  "personal_discount_type_id": "id",
  "payment_method": {
    "payment_method_type": "service_credits"
  }
}
"""

private val personalDiscountPurchaseRequest =
    """
{
  "personal_discount_type_id": "id",
  "payment_method": {
    "payment_method_type": "service_credits"
  },
  "paypal_secure_element": "secure_element",
  "valid_from": "2024-05-15T16:33:46Z"
}
"""
