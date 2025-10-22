package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiStripeTypeSerializer::class)
public enum class ApiStripeType {
    @SerialName(value = "card")
    CARD,

    @SerialName(value = "sepa_debit")
    SEPA_DEBIT,
    UNSUPPORTED,
}

internal object ApiStripeTypeSerializer : KSerializer<ApiStripeType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiStripeType) {
        encoder.encodeString(
            when (value) {
                ApiStripeType.CARD -> "card"
                ApiStripeType.SEPA_DEBIT -> "sepa_debit"
                ApiStripeType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiStripeType = when (decoder.decodeString()) {
        "card" -> ApiStripeType.CARD
        "sepa_debit" -> ApiStripeType.SEPA_DEBIT
        else -> ApiStripeType.UNSUPPORTED
    }
}
