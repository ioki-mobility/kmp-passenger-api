package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideOptions(
    val passengers: Passenger,
    @SerialName(value = "destination_time_based_matching")
    val destinationTimeBasedMatching: Boolean,
    @SerialName(value = "prebooking_threshold")
    val preBookingThreshold: PreBookingThreshold?,
) {
    @Serializable
    public data class Passenger(
        @SerialName(value = "name_required_if_no_public_transport_ticket")
        val nameRequiredIfNoPublicTransportTicket: Boolean,
    )

    @Serializable
    public data class PreBookingThreshold(
        @SerialName(value = "min")
        val minSeconds: Int,
        @SerialName(value = "max")
        val maxSeconds: Int,
    )
}
