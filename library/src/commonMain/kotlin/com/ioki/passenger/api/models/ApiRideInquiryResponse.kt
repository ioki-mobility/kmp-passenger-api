package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiRideInquiryResponse.Assistance.ErrorCode
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiRideInquiryResponse(
    val availability: Availability,
    val constraints: Constraints,
    val assistances: List<Assistance>,
) {
    @Serializable
    public data class Availability(
        val available: Boolean,
        @SerialName(value = "next_availability") val nextAvailability: Instant?,
    )

    @Serializable
    public data class Constraints(
        val area: ApiArea?,
    )

    @Serializable
    public data class Assistance(
        val title: String,
        val text: String,
        val href: String?,
        @SerialName("error_code") val errorCode: ErrorCode?,
    ) {
        @Serializable(with = ErrorCodeSerializer::class)
        public enum class ErrorCode {
            @SerialName("service_not_available")
            SERVICE_NOT_AVAILABLE,

            @SerialName("origin_outside_of_service_area")
            ORIGIN_OUTSIDE_OF_SERVICE_AREA,

            @SerialName("destination_outside_of_service_area")
            DESTINATION_OUTSIDE_OF_SERVICE_AREA,

            UNSUPPORTED,
        }
    }
}

internal object ErrorCodeSerializer : KSerializer<ErrorCode> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ErrorCode", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ErrorCode) {
        encoder.encodeString(
            when (value) {
                ErrorCode.SERVICE_NOT_AVAILABLE -> "service_not_available"
                ErrorCode.ORIGIN_OUTSIDE_OF_SERVICE_AREA -> "origin_outside_of_service_area"
                ErrorCode.DESTINATION_OUTSIDE_OF_SERVICE_AREA -> "destination_outside_of_service_area"
                ErrorCode.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ErrorCode {
        return when (decoder.decodeString()) {
            "service_not_available" -> ErrorCode.SERVICE_NOT_AVAILABLE
            "origin_outside_of_service_area" -> ErrorCode.ORIGIN_OUTSIDE_OF_SERVICE_AREA
            "destination_outside_of_service_area" -> ErrorCode.DESTINATION_OUTSIDE_OF_SERVICE_AREA
            else -> ErrorCode.UNSUPPORTED
        }
    }
}
