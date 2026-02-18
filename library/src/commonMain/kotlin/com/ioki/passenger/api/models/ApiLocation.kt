package com.ioki.passenger.api.models

import kotlin.time.Instant
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
    @SerialName(value = "formatted_address") val formattedAddress: String,
    val type: String?,
    val time: Instant?,
    @SerialName(value = "waypoint_type") val waypointType: String?,
    @SerialName(value = "station_id") val stationId: String?,
    @SerialName(value = "walking_duration") val walkingDuration: Long?,
    @SerialName(value = "walking_track") val walkingTrack: String?,
    @SerialName(value = "station") val station: ApiStationResponse?,
    @SerialName(value = "display_times") val displayTimes: List<Instant>,
)
