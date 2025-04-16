package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiPurchaseTypeSerializer::class)
public enum class ApiPurchaseType {
    @SerialName(value = "credit")
    CREDIT,

    @SerialName(value = "debit")
    DEBIT,

    UNSUPPORTED,
}

private object ApiPurchaseTypeSerializer : KSerializer<ApiPurchaseType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPurchaseType) {
        encoder.encodeString(
            when (value) {
                ApiPurchaseType.CREDIT -> "credit"
                ApiPurchaseType.DEBIT -> "debit"
                ApiPurchaseType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPurchaseType {
        return when (decoder.decodeString()) {
            "credit" -> ApiPurchaseType.CREDIT
            "debit" -> ApiPurchaseType.DEBIT
            else -> ApiPurchaseType.UNSUPPORTED
        }
    }
}
