package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCancellationStatement(
    val id: String,
    val title: String,
    @SerialName(value = "suitable_for_ride_series") val suitableForRideSeries: Boolean,
    @SerialName(value = "suitable_for_single_rides") val suitableForSingleRides: Boolean,
)
