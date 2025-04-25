package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiPurchasableTypeSerializer::class)
public enum class ApiPurchasableType {
    @SerialName(value = "Booking")
    BOOKING,

    @SerialName(value = "Tip")
    TIP,

    @SerialName(value = "ServiceCredit")
    SERVICE_CREDIT,

    @SerialName(value = "PersonalDiscount")
    PERSONAL_DISCOUNT,

    @SerialName(value = "Ticketing::Voucher")
    TICKETING_VOUCHER,

    UNSUPPORTED,
}

private object ApiPurchasableTypeSerializer : KSerializer<ApiPurchasableType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPurchasableType) {
        encoder.encodeString(
            when (value) {
                ApiPurchasableType.BOOKING -> "Booking"
                ApiPurchasableType.TIP -> "Tip"
                ApiPurchasableType.SERVICE_CREDIT -> "ServiceCredit"
                ApiPurchasableType.PERSONAL_DISCOUNT -> "PersonalDiscount"
                ApiPurchasableType.TICKETING_VOUCHER -> "Ticketing::Voucher"
                ApiPurchasableType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPurchasableType {
        return when (decoder.decodeString()) {
            "Booking" -> ApiPurchasableType.BOOKING
            "Tip" -> ApiPurchasableType.TIP
            "ServiceCredit" -> ApiPurchasableType.SERVICE_CREDIT
            "PersonalDiscount" -> ApiPurchasableType.PERSONAL_DISCOUNT
            "Ticketing::Voucher" -> ApiPurchasableType.TICKETING_VOUCHER
            else -> ApiPurchasableType.UNSUPPORTED
        }
    }
}
