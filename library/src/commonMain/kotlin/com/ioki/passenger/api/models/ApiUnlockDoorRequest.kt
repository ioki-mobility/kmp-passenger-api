package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUnlockDoorRequest(
    @SerialName(value = "desired_state") val desiredState: String,
)
