package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiLocation(
    val lat: Double,
    val lng: Double,
    @SerialName(value = "location_name") val locationName: String?,
    @SerialName(value = "street_name") val streetName: String?,
    @SerialName(value = "street_number") val streetNumber: String?,
    @SerialName(value = "postal_code") val postalCode: String?,
    val city: String?,
    val county: String?,
    val country: String?,
    val type: String?,
    val time: Instant?,
    @SerialName(value = "waypoint_type") val waypointType: String?,
    @SerialName(value = "station_id") val stationId: String?,
    @SerialName(value = "walking_duration") val walkingDuration: Long?,
    @SerialName(value = "walking_track") val walkingTrack: String?,
    @SerialName(value = "station") val station: ApiStationResponse?,
    @SerialName(value = "display_times") val displayTimes: List<Instant>,
) : Addressable {
    override val address: ApiAddress
        get() =
            ApiAddress(
                locationName = locationName ?: "",
                streetName = streetName ?: "",
                streetNumber = streetNumber ?: "",
                postalCode = postalCode ?: "",
                city = city ?: "",
                county = county ?: "",
                country = country ?: "",
            )
}

// If the given pickup or dropoff point has a station or a walkingDuration greater than zero,
// location is different to the origin or destination point.
public val ApiLocation?.hasDifferentPoint: Boolean
    get() =
        when {
            this == null -> false
            stationId != null -> true
            else -> walkingDuration ?: 0 > 0
        }

// If the given pickup or dropoff point has a station or the duration is greater than zero,
// location is different to the origin or destination point.
public fun ApiLocation?.hasDifferentPoint(hopDuration: Int): Boolean = when {
    this == null -> false
    stationId != null -> true
    else -> hopDuration > 0
}
