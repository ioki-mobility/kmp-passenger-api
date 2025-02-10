package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiLocation
import com.ioki.passenger.api.models.ApiOption
import com.ioki.passenger.api.models.ApiPassengerSelectionRequest
import com.ioki.passenger.api.models.ApiRideRequest

public fun createApiRideRequest(
    productId: String = "",
    passengers: List<ApiPassengerSelectionRequest> = emptyList(),
    options: List<ApiOption> = emptyList(),
    origin: ApiLocation = createApiLocation(),
    destination: ApiLocation = createApiLocation(),
    driverNote: String? = null,
): ApiRideRequest = ApiRideRequest(
    productId = productId,
    passengers = passengers,
    options = options,
    origin = origin,
    destination = destination,
    driverNote = driverNote,
)
