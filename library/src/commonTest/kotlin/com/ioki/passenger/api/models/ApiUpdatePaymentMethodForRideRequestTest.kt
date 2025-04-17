package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUpdatePaymentMethodForRideRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiUpdatePaymentMethodForRideRequest(
                paymentMethod = ApiPaymentMethodRequest(
                    paymentMethodType = ApiPaymentMethodType.STRIPE,
                    id = "pam_123",
                ),
                rideVersion = 42,
                paypalSecureElement = "1234",
            ),
            jsonString = updatePaymentMethodForRideRequestJson,
        )
    }
}

private val updatePaymentMethodForRideRequestJson: String = """
{
  "payment_method": {
    "payment_method_type": "stripe",
    "id": "pam_123"
  },
  "ride_version": 42,
  "paypal_secure_element": "1234"
}
""".trimIndent()
