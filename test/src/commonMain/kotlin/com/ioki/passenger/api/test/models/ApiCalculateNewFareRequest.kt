package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCalculateNewFareRequest
import com.ioki.passenger.api.models.ApiPassengerSelectionRequest

public fun createApiCalculateNewFareRequest(
    passengers: List<ApiPassengerSelectionRequest> = emptyList(),
): ApiCalculateNewFareRequest = ApiCalculateNewFareRequest(
    passengers = passengers,
)
