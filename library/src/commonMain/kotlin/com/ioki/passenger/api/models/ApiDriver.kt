package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiDriver(
    @SerialName(value = "connected_vehicle_id") val connectedVehicleId: String,
    @SerialName(value = "display_name") val displayName: String?,
)
