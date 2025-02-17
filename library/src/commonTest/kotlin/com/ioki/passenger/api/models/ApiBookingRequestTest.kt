package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiBookingRequestTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiBookingRequest(
                rideVersion = 2,
                solutionId = null,
                paymentMethod = ApiPaymentMethodRequest(ApiPaymentMethodType.CASH, null, null),
                paypalSecureElement = null,
            ),
            bookingRequestMinimal,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiBookingRequest(
                rideVersion = 2,
                solutionId = "solutionId",
                paymentMethod = ApiPaymentMethodRequest(ApiPaymentMethodType.CASH, null, null),
                paypalSecureElement = "secure_element",
            ),
            bookingRequest,
        )
    }
}

private val bookingRequestMinimal =
    """
{
  "ride_version": 2,
  "payment_method": {
    "payment_method_type": "cash"
  }
}
"""

private val bookingRequest =
    """
{
  "ride_version": 2,
  "solution_id": "solutionId",
  "payment_method": {
    "payment_method_type": "cash"
  },
  "paypal_secure_element": "secure_element"
}
"""
