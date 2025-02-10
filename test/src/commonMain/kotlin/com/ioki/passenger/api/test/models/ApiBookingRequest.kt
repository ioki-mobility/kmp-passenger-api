package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBookingRequest
import com.ioki.passenger.api.models.ApiPaymentMethodRequest

public fun createApiBookingRequest(
    rideVersion: Int = 0,
    solutionId: String? = null,
    paymentMethod: ApiPaymentMethodRequest? = null,
    paypalSecureElement: String? = null,
): ApiBookingRequest = ApiBookingRequest(
    rideVersion = rideVersion,
    solutionId = solutionId,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
)
