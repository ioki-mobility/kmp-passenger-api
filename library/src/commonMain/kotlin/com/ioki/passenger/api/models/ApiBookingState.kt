package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ApiBookingState {
    @SerialName(value = "not_started")
    NOT_STARTED,

    @SerialName(value = "searching")
    SEARCHING,

    @SerialName(value = "ready")
    READY,

    @SerialName(value = "passenger_accepted")
    PASSENGER_ACCEPTED,

    @SerialName(value = "driver_accepted")
    DRIVER_ACCEPTED,

    @SerialName(value = "picked_up")
    PICKED_UP,

    @SerialName(value = "dropped_off")
    DROPPED_OFF,

    @SerialName(value = "cancelled")
    CANCELLED,
    UNSUPPORTED,
}
