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
public data class ApiDoorStateChangeRequest(
    @SerialName(value = "desired_state") val desiredState: DesiredState,
) {
    @Serializable(with = DesiredStateSerializer::class)
    public enum class DesiredState {
        @SerialName(value = "unlocked")
        UNLOCKED,
        UNSUPPORTED,
    }
}

internal object DesiredStateSerializer : KSerializer<ApiDoorStateChangeRequest.DesiredState> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DesiredState", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ApiDoorStateChangeRequest.DesiredState) {
        encoder.encodeString(
            when (value) {
                ApiDoorStateChangeRequest.DesiredState.UNLOCKED -> "unlocked"
                ApiDoorStateChangeRequest.DesiredState.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiDoorStateChangeRequest.DesiredState {
        return when (decoder.decodeString()) {
            "unlocked" -> ApiDoorStateChangeRequest.DesiredState.UNLOCKED
            else -> ApiDoorStateChangeRequest.DesiredState.UNSUPPORTED
        }
    }
}
