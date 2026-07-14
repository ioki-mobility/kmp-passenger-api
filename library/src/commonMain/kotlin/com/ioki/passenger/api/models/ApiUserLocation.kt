
package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiUserLocation(
    val id: String,
    val version: Int,
    val title: String,
    val locationType: Type,
    val lat: Double,
    val lng: Double,
    @SerialName(value = "location_name") val locationName: String?,
    @SerialName(value = "street_name") val streetName: String?,
    @SerialName(value = "street_number") val streetNumber: String?,
    @SerialName(value = "postal_code") val postalCode: String?,
    val city: String?,
    val county: String?,
    val country: String?,
    @SerialName(value = "editable_by_user") val editableByUser: Boolean,
    @SerialName(value = "user_id") val userId: String,
    @SerialName(value = "custom_flags") val customFlags: List<CustomFlag>,
) {
    @Serializable(with = ApiUserLocationTypeSerializer::class)
    public enum class Type {
        HOME,
        WORK,
        OTHER,
    }

    @Serializable
    public data class CustomFlag(
        val slug: String,
        val name: String,
    )
}

internal object ApiUserLocationTypeSerializer : KSerializer<ApiUserLocation.Type> {
    override val descriptor: SerialDescriptor
        get() = String.serializer().descriptor

    override fun serialize(
        encoder: Encoder,
        value: ApiUserLocation.Type,
    ) {
        encoder.encodeString(
            when (value) {
                ApiUserLocation.Type.HOME -> "home"
                ApiUserLocation.Type.WORK -> "work"
                ApiUserLocation.Type.OTHER -> "other"
            }
        )
    }

    override fun deserialize(decoder: Decoder): ApiUserLocation.Type {
        return when (decoder.decodeString()) {
            "home" -> ApiUserLocation.Type.HOME
            "work" -> ApiUserLocation.Type.WORK
            "other" -> ApiUserLocation.Type.OTHER
            else -> ApiUserLocation.Type.OTHER
        }
    }
}
