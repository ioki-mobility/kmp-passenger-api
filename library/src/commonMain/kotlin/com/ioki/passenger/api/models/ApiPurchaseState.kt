package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiPurchaseStateSerializer::class)
public enum class ApiPurchaseState {
    @SerialName(value = "succeeded")
    SUCCEEDED,

    @SerialName(value = "forfeited")
    FORFEITED,

    @SerialName(value = "cancelled")
    CANCELLED,

    @SerialName(value = "not_initiated")
    NOT_INITIATED,

    @SerialName(value = "pending")
    PENDING,

    @SerialName(value = "reserved")
    RESERVED,

    @SerialName(value = "failed")
    FAILED,

    UNSUPPORTED,
}

internal object ApiPurchaseStateSerializer : KSerializer<ApiPurchaseState> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPurchaseState) {
        encoder.encodeString(
            when (value) {
                ApiPurchaseState.SUCCEEDED -> "succeeded"
                ApiPurchaseState.FORFEITED -> "forfeited"
                ApiPurchaseState.CANCELLED -> "cancelled"
                ApiPurchaseState.NOT_INITIATED -> "not_initiated"
                ApiPurchaseState.PENDING -> "pending"
                ApiPurchaseState.RESERVED -> "reserved"
                ApiPurchaseState.FAILED -> "failed"
                ApiPurchaseState.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPurchaseState = when (decoder.decodeString()) {
        "succeeded" -> ApiPurchaseState.SUCCEEDED
        "forfeited" -> ApiPurchaseState.FORFEITED
        "cancelled" -> ApiPurchaseState.CANCELLED
        "not_initiated" -> ApiPurchaseState.NOT_INITIATED
        "pending" -> ApiPurchaseState.PENDING
        "reserved" -> ApiPurchaseState.RESERVED
        "failed" -> ApiPurchaseState.FAILED
        else -> ApiPurchaseState.UNSUPPORTED
    }
}
