package com.ioki.passenger.api.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiOfferedSolution(
    val type: String,
    val id: String,
    val bookable: Boolean,
    val fare: ApiFareResponse?,
    val hops: List<Hop>,
) {
    @Serializable
    public data class Hop(
        @SerialName(value = "transport_mode")
        val transportMode: TransportMode = TransportMode.UNSUPPORTED,
        val from: ApiLocation,
        val to: ApiLocation,
        val track: String?,
        val duration: Int,
        val vehicle: ApiVehicle?,
        val details: Details?,
    ) {
        @Serializable
        public data class Details(
            val direction: String?,
            val name: String?,
            @SerialName(value = "transport_type")
            @Serializable(with = ApiPublicTransportTypeSerializer::class)
            val transportType: ApiPublicTransportType?,
        )

        @Serializable
        public enum class TransportMode {
            @SerialName(value = "walk")
            WALK,

            @SerialName(value = "drt")
            DRT,

            @SerialName(value = "public_transport")
            PUBLIC_TRANSPORT,
            UNSUPPORTED,
        }
    }
}

private object ApiPublicTransportTypeSerializer : KSerializer<ApiPublicTransportType?> {
    override val descriptor = String.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: ApiPublicTransportType?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }

        encoder.encodeString(
            when (value) {
                ApiPublicTransportType.BUS -> "bus"
                ApiPublicTransportType.UNDERGROUND -> "underground"
                ApiPublicTransportType.TRAM -> "tram"
                ApiPublicTransportType.TRAIN_LONG_DISTANCE -> "long_distance_train"
                ApiPublicTransportType.TRAIN_SUBURBAN_TRAIN -> "suburban_train"
                ApiPublicTransportType.TRAIN_REGIONAL -> "regional_train"
                ApiPublicTransportType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): ApiPublicTransportType? {
        val stringValue =
            decoder.decodeNullableSerializableValue(String.serializer().nullable) ?: return null

        return when (stringValue) {
            "bus" -> ApiPublicTransportType.BUS
            "underground" -> ApiPublicTransportType.UNDERGROUND
            "tram" -> ApiPublicTransportType.TRAM
            "long_distance_train" -> ApiPublicTransportType.TRAIN_LONG_DISTANCE
            "suburban_train" -> ApiPublicTransportType.TRAIN_SUBURBAN_TRAIN
            "regional_train" -> ApiPublicTransportType.TRAIN_REGIONAL
            else -> ApiPublicTransportType.UNSUPPORTED
        }
    }
}
