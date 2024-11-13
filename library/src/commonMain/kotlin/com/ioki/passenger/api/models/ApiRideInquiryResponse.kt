package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideInquiryResponse(
    val availability: Availability,
    val constraints: Constraints,
    val errors: List<String>,
    val assistances: List<Assistance>,
) {
    @Serializable
    public data class Availability(
        val available: Boolean,
        @SerialName(value = "next_availability") val nextAvailability: Instant?,
    )

    @Serializable
    public data class Constraints(
        val area: ApiArea?,
        @SerialName(value = "max_passengers") val maxPassengers: Int?,
    )

    @Serializable
    public data class Assistance(
        val title: String,
        val text: String,
        val href: String?,
    )
}
