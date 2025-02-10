package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingResponse

public fun createApiRatingResponse(
    id: String = "",
    rideRating: Int? = null,
    waitingTimeRating: Int? = null,
    punctualityRating: Int? = null,
    driverRating: Int? = null,
    vehicleRating: Int? = null,
    serviceRating: Int? = null,
): ApiRatingResponse = ApiRatingResponse(
    id = id,
    rideRating = rideRating,
    waitingTimeRating = waitingTimeRating,
    punctualityRating = punctualityRating,
    driverRating = driverRating,
    vehicleRating = vehicleRating,
    serviceRating = serviceRating,
)
