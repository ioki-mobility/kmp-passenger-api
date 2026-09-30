package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiUpdatePaymentMethodForRideRequest

public fun createApiUpdatePaymentMethodForRideRequest(
    rideVersion: Int = 0,
    paypalSecureElement: String? = null,
    paymentMethod: ApiPaymentMethodRequest,
    onSession: Boolean? = null,
    async: Boolean? = null,
): ApiUpdatePaymentMethodForRideRequest = ApiUpdatePaymentMethodForRideRequest(
    rideVersion = rideVersion,
    paypalSecureElement = paypalSecureElement,
    paymentMethod = paymentMethod,
    onSession = onSession,
    async = async,
)
