package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiVenueResponse(
    val id: String,
    val city: String,
    val county: String,
    val country: String,
    @SerialName(value = "formatted_street") val formattedStreet: String,
    val lat: Double,
    val lng: Double,
    @SerialName(value = "location_name") val locationName: String?,
    @SerialName(value = "postal_code") val postalCode: String?,
    @SerialName(value = "product_id") val productId: String,
    @SerialName(value = "street_name") val streetName: String?,
    @SerialName(value = "street_number") val streetNumber: String?,
    @SerialName(value = "venue_type") val venueType: VenueType = VenueType.OTHER,
) {
    @Serializable
    public enum class VenueType {
        @SerialName(value = "drug_store")
        DRUGSTORE,

        @SerialName(value = "coffee")
        COFFEE,

        @SerialName(value = "wine_bar")
        WINEBAR,

        @SerialName(value = "restaurant")
        RESTAURANT,

        @SerialName(value = "hospital")
        HOSPITAL,

        @SerialName(value = "grocery_store")
        GROCERYSTORE,

        @SerialName(value = "hotel")
        HOTEL,

        @SerialName(value = "station")
        STATION,

        @SerialName(value = "tram")
        TRAM,

        @SerialName(value = "bus")
        BUS,

        @SerialName(value = "train")
        TRAIN,

        @SerialName(value = "sharing_station")
        SHARING_STATION,

        @SerialName(value = "other")
        OTHER,
    }
}
