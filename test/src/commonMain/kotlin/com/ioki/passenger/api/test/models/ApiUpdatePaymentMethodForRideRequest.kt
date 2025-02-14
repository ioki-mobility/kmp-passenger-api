package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiUpdatePaymentMethodForRideRequest

public fun createApiUpdatePaymentMethodForRideRequest(
    rideVersion: Int = 0,
    paypalSecureElement: String? = null,
    paymentMethod: ApiPaymentMethodRequest,
): ApiUpdatePaymentMethodForRideRequest = ApiUpdatePaymentMethodForRideRequest(
    rideVersion = rideVersion,
    paypalSecureElement = paypalSecureElement,
    paymentMethod = paymentMethod,
)
