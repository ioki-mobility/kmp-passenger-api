package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiUnlockDoorRequest(
    @SerialName(value = "desired_state") val desiredState: DesiredState,
) {
    @Serializable(with = DesiredStateSerializer::class)
    public enum class DesiredState {
        @SerialName(value = "unlocked")
        UNLOCKED,
        UNSUPPORTED,
    }
}

internal object DesiredStateSerializer : KSerializer<ApiUnlockDoorRequest.DesiredState> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DesiredState", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ApiUnlockDoorRequest.DesiredState) {
        encoder.encodeString(
            when (value) {
                ApiUnlockDoorRequest.DesiredState.UNLOCKED -> "unlocked"
                ApiUnlockDoorRequest.DesiredState.UNSUPPORTED -> "unsupported"
            }
        )
    }

    override fun deserialize(decoder: Decoder): ApiUnlockDoorRequest.DesiredState {
        return when (decoder.decodeString()) {
            "unlocked" -> ApiUnlockDoorRequest.DesiredState.UNLOCKED
            else -> ApiUnlockDoorRequest.DesiredState.UNSUPPORTED
        }
    }
}

