package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiCreateTipRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiCreateTipRequest(
                amount = 150,
                paymentMethod = createApiPaymentMethodRequest(ApiPaymentMethodType.SERVICE_CREDITS),
                paypalSecureElement = null,
            ),
            createTipRequest,
        )
    }
}

private val createTipRequest =
    """
{
  "amount": 150,
  "payment_method": {
    "payment_method_type": "service_credits"
  }
}
"""
