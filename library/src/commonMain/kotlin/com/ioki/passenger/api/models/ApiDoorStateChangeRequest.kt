package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiDoorStateChangeRequest(@SerialName(value = "desired_state") val desiredState: DesiredState) {
    @Serializable
    public enum class DesiredState {
        @SerialName(value = "unlocked")
        UNLOCKED,
    }
}
