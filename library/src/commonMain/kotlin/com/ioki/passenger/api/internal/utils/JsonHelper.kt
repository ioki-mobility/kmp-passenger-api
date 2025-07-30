package com.ioki.passenger.api.internal.utils

import com.ioki.passenger.api.models.ApiFailedPaymentResponse
import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

internal fun createJson() = Json {
    coerceInputValues = true
    ignoreUnknownKeys = true
    explicitNulls = false

    serializersModule =
        SerializersModule {
            contextual(LocalDate::class, LocalDateSerializer)
            contextual(LocalDateTime::class, LocalDateTimeSerializer)
            contextual(Instant::class, InstantSerializer)
            polymorphic(ApiFirebaseDebugRecordRequest.Payload::class) {
                subclass(ApiFirebaseDebugRecordRequest.Payload.RidePayload::class)
                subclass(ApiFirebaseDebugRecordRequest.Payload.VehiclePositionPayload::class)
            }
            polymorphic(ApiFailedPaymentResponse::class) {
                subclass(ApiFailedPaymentResponse.PaymentRecovery::class)
                subclass(ApiFailedPaymentResponse.StripeIntent::class)
                subclass(ApiFailedPaymentResponse.Unknown::class)
            }
        }
}

private object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    private val formatter = LocalDateTime.Formats.ISO

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(formatter.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.parse(decoder.decodeString(), formatter)
    }
}

private object LocalDateSerializer : KSerializer<LocalDate> {
    private val formatter = LocalDate.Formats.ISO

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(formatter.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString(), formatter)
    }
}

private object InstantSerializer : KSerializer<Instant> {
    private val formatter = LocalDateTime.Formats.ISO

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeString(formatter.format(value.toLocalDateTime(TimeZone.UTC)))
    }

    override fun deserialize(decoder: Decoder): Instant {
        LocalDateTime.parse(decoder.decodeString(), formatter).run {
            return toInstant(TimeZone.UTC)
        }
    }
}
