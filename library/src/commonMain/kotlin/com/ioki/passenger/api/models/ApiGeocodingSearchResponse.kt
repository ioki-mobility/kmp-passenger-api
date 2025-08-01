package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiGeocodingSearchResponse(val results: List<SearchResult>) {
    @Serializable
    public data class SearchResult(
        val id: String,
        val lat: Double,
        val lng: Double,
        val vendor: String,
        @SerialName(value = "vendor_id") val vendorId: String,
        @SerialName(value = "location_name") val locationName: String?,
        @SerialName(value = "formatted_address") val formattedAddress: String?,
        val description: String?,
    )
}
