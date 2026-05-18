package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiVerificationChannelTypeSerializer::class)
public enum class ApiVerificationChannelType {
    @SerialName(value = "sms")
    SMS,

    @SerialName(value = "email")
    EMAIL,
    UNSUPPORTED,
}

internal object ApiVerificationChannelTypeSerializer : KSerializer<ApiVerificationChannelType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiVerificationChannelType) {
        encoder.encodeString(
            when (value) {
                ApiVerificationChannelType.SMS -> "sms"
                ApiVerificationChannelType.EMAIL -> "email"
                ApiVerificationChannelType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiVerificationChannelType = when (decoder.decodeString()) {
        "sms" -> ApiVerificationChannelType.SMS
        "email" -> ApiVerificationChannelType.EMAIL
        else -> ApiVerificationChannelType.UNSUPPORTED
    }
}
