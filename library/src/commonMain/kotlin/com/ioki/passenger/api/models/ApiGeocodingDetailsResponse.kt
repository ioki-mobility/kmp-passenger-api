package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse.VendorType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
    @Serializable(with = VendorTypeSerializer::class)
    public enum class VendorType {
        @SerialName("station")
        STATION,

        @SerialName("places")
        PLACES,

        UNSUPPORTED,
    }
}

private object VendorTypeSerializer : KSerializer<VendorType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: VendorType) {
        encoder.encodeString(
            when (value) {
                VendorType.STATION -> "station"
                VendorType.PLACES -> "places"
                VendorType.UNSUPPORTED -> "UNSUPPORTED"
            },
        )
    }

    override fun deserialize(decoder: Decoder): VendorType = when (decoder.decodeString()) {
        "station" -> VendorType.STATION
        "places" -> VendorType.PLACES
        else -> VendorType.UNSUPPORTED
    }
}
