package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRatingResponse(
    val id: String,
    @SerialName(value = "ride_rating") val rideRating: Int?,
    @SerialName(value = "waiting_time_rating") val waitingTimeRating: Int?,
    @SerialName(value = "punctuality_rating") val punctualityRating: Int?,
    @SerialName(value = "driver_rating") val driverRating: Int?,
    @SerialName(value = "vehicle_rating") val vehicleRating: Int?,
    @SerialName(value = "service_rating") val serviceRating: Int?,
)
