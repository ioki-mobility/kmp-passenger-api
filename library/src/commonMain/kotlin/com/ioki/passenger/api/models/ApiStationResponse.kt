package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiStationResponse(
    val id: String,
    val lat: Double,
    val lng: Double,
    @SerialName(value = "location_name") val locationName: String,
    @SerialName(value = "street_name") val streetName: String?,
    @SerialName(value = "street_number") val streetNumber: String?,
    @SerialName(value = "postal_code") val postalCode: String?,
    val city: String?,
    val county: String?,
    val country: String?,
    val description: String?,
    val avatar: ApiAvatar?,
    @SerialName(value = "transport_station_types")
    val publicTransportTypes: List<ApiPublicTransportType>?,
    @SerialName(value = "transport_connections_url") val publicTransportScheduleUrl: String?,
    @SerialName(value = "visible_on_map") val visibleOnMap: Boolean,
) : Addressable {
    override val address: ApiAddress
        get() =
            ApiAddress(
                locationName = locationName,
                streetName = streetName ?: "",
                streetNumber = streetNumber ?: "",
                postalCode = postalCode ?: "",
                city = city ?: "",
                county = county ?: "",
                country = country ?: "",
            )
}
