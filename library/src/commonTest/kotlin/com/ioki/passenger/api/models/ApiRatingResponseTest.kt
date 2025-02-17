package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRatingResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingResponse(
                id = "abc123",
                rideRating = 1,
                waitingTimeRating = 2,
                punctualityRating = 3,
                driverRating = 3,
                vehicleRating = 3,
                serviceRating = 3,
            ),
            ratingResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingResponse(
                id = "abc123",
                rideRating = null,
                waitingTimeRating = null,
                punctualityRating = null,
                driverRating = null,
                vehicleRating = null,
                serviceRating = null,
            ),
            ratingResponseMinimal,
        )
    }
}

private val ratingResponse =
    """
{
  "id": "abc123",
  "ride_rating": 1,
  "waiting_time_rating": 2,
  "punctuality_rating": 3,
  "driver_rating": 3,
  "vehicle_rating": 3,
  "service_rating": 3
}
"""

private val ratingResponseMinimal =
    """
{
  "id": "abc123"
}
"""
