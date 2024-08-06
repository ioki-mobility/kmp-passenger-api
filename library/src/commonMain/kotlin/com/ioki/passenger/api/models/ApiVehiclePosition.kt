package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiVehiclePosition(
    val lat: Double,
    val lng: Double,
    val heading: Float?,
)
