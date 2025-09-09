package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult.Vendor
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiGeocodingSearchResponse(val results: List<SearchResult>) {
    @Serializable
    public data class SearchResult(
        val id: String,
        val lat: Double?,
        val lng: Double?,
        val vendor: Vendor,
        @SerialName(value = "vendor_id") val vendorId: String,
        @SerialName(value = "location_name") val locationName: String?,
        @SerialName(value = "formatted_address") val formattedAddress: String?,
        val description: String?,
    ) {
        @Serializable(with = VendorSerializer::class)
        public enum class Vendor {
            @SerialName("google")
            GOOGLE,

            @SerialName("ioki")
            IOKI,

            UNSUPPORTED,
        }
    }
}

private object VendorSerializer : KSerializer<Vendor> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Vendor) {
        encoder.encodeString(
            when (value) {
                Vendor.GOOGLE -> "google"
                Vendor.IOKI -> "ioki"
                Vendor.UNSUPPORTED -> "UNSUPPORTED"
            },
        )
    }

    override fun deserialize(decoder: Decoder): Vendor {
        return when (decoder.decodeString()) {
            "google" -> Vendor.GOOGLE
            "ioki" -> Vendor.IOKI
            else -> Vendor.UNSUPPORTED
        }
    }
}
