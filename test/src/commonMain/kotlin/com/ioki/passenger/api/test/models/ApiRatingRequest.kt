package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingRequest

public fun createApiRatingRequest(
    rideVersion: Int = 0,
    rideRating: Int? = null,
    waitingTimeRating: Int? = null,
    punctualityRating: Int? = null,
    driverRating: Int? = null,
    vehicleRating: Int? = null,
    serviceRating: Int? = null,
    vehicleCleanlinessRating: Int? = null,
    comment: String? = null,
): ApiRatingRequest = ApiRatingRequest(
    rideVersion = rideVersion,
    rideRating = rideRating,
    waitingTimeRating = waitingTimeRating,
    punctualityRating = punctualityRating,
    driverRating = driverRating,
    vehicleRating = vehicleRating,
    serviceRating = serviceRating,
    vehicleCleanlinessRating = vehicleCleanlinessRating,
    comment = comment,
)
