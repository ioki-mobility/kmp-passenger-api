package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideInquiryRequest(
    @SerialName(value = "product_id") val productId: String,
    val origin: Location,
    val destination: Location,
    val passengers: List<ApiPassengerSelectionRequest>?,
) {
    @Serializable
    public data class Location(
        val lat: Double?,
        val lng: Double?,
        @SerialName(value = "location_name") val locationName: String?,
        @SerialName(value = "street_name") val streetName: String?,
        @SerialName(value = "street_number") val streetNumber: String?,
        @SerialName(value = "postal_code") val postalCode: String?,
        val city: String?,
        val county: String?,
        val country: String?,
        val time: Instant?,
        @SerialName(value = "station_id") val stationId: String?,
    )
}
