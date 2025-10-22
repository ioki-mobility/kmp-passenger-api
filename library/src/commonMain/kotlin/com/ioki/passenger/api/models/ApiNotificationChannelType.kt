package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiNotificationChannelTypeSerializer::class)
public enum class ApiNotificationChannelType {
    @SerialName(value = "sms")
    SMS,

    @SerialName(value = "email")
    EMAIL,
    UNSUPPORTED,
}

internal object ApiNotificationChannelTypeSerializer : KSerializer<ApiNotificationChannelType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiNotificationChannelType) {
        encoder.encodeString(
            when (value) {
                ApiNotificationChannelType.SMS -> "sms"
                ApiNotificationChannelType.EMAIL -> "email"
                else -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiNotificationChannelType = when (decoder.decodeString()) {
        "sms" -> ApiNotificationChannelType.SMS
        "email" -> ApiNotificationChannelType.EMAIL
        else -> ApiNotificationChannelType.UNSUPPORTED
    }
}
