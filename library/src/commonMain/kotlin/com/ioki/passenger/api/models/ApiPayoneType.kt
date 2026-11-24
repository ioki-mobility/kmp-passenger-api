package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiPayoneTypeSerializer::class)
public enum class ApiPayoneType {
    @SerialName(value = "card")
    CARD,
    UNSUPPORTED,
}

internal object ApiPayoneTypeSerializer : KSerializer<ApiPayoneType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPayoneType) {
        encoder.encodeString(
            when (value) {
                ApiPayoneType.CARD -> "card"
                ApiPayoneType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPayoneType = when (decoder.decodeString()) {
        "card" -> ApiPayoneType.CARD
        else -> ApiPayoneType.UNSUPPORTED
    }
}
