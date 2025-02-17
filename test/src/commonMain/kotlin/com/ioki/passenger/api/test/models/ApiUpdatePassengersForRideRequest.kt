package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPassengerSelectionRequest
import com.ioki.passenger.api.models.ApiUpdatePassengersForRideRequest

public fun createApiUpdatePassengersForRideRequest(
    passengers: List<ApiPassengerSelectionRequest> = emptyList(),
    rideVersion: Int = 0,
    fareVersion: Int = 0,
    paypalSecureElement: String? = null,
    requirePaymentMethodForPaidChange: Boolean = false,
): ApiUpdatePassengersForRideRequest = ApiUpdatePassengersForRideRequest(
    passengers = passengers,
    rideVersion = rideVersion,
    fareVersion = fareVersion,
    paypalSecureElement = paypalSecureElement,
    requirePaymentMethodForPaidChange = requirePaymentMethodForPaidChange,
)
