package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRatingRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingRequest(
                rideVersion = 2,
                rideRating = 1,
                waitingTimeRating = 2,
                punctualityRating = 3,
                driverRating = 3,
                vehicleRating = 3,
                serviceRating = 3,
                vehicleCleanlinessRating = 5,
                comment = "Nice comment",
            ),
            ratingRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingRequest(
                rideVersion = 2,
                rideRating = null,
                waitingTimeRating = null,
                punctualityRating = null,
                driverRating = null,
                vehicleRating = null,
                serviceRating = null,
                vehicleCleanlinessRating = null,
                comment = null,
            ),
            ratingRequestMinimal,
        )
    }
}

private val ratingRequest =
    """
{
  "ride_version": 2,
  "ride_rating": 1,
  "waiting_time_rating": 2,
  "punctuality_rating": 3,
  "driver_rating": 3,
  "vehicle_rating": 3,
  "service_rating":  3,
  "vehicle_cleanliness_rating":  5,
  "comment": "Nice comment"
}
"""

private val ratingRequestMinimal =
    """
{
  "ride_version": 2
}
"""
