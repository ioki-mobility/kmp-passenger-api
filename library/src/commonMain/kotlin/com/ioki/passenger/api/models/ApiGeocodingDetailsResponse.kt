package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiGeocodingDetailsResponse(
    val lat: Double,
    val lng: Double,
    val vendor: String,
    @SerialName(value = "vendor_id") val vendorId: String,
    @SerialName(value = "vendor_type") val vendorType: VendorType,
    @SerialName(value = "location_name") val locationName: String?,
    @SerialName(value = "formatted_address") val formattedAddress: String?,
    @SerialName(value = "street_name") val streetName: String?,
    @SerialName(value = "street_number") val streetNumber: String?,
    @SerialName(value = "postal_code") val postalCode: String?,
    val city: String?,
    val county: String?,
    val country: String?,
) {
    @Serializable
    public enum class VendorType {
        @SerialName("station")
        STATION,

        @SerialName("places")
        PLACES,

        UNSUPPORTED,
    }
}
