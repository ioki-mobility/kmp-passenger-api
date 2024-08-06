package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdatePassengersForRideRequest(
    val passengers: List<ApiPassengerSelectionRequest>,
    @SerialName(value = "ride_version")
    val rideVersion: Int,
    @SerialName(value = "fare_version")
    val fareVersion: Int,
    @SerialName(value = "paypal_secure_element")
    val paypalSecureElement: String?,
)
