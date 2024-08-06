package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiPaymentMethodTypeSerializer::class)
public enum class ApiPaymentMethodType {
    @SerialName(value = "cash")
    CASH,

    @SerialName(value = "psp_provided")
    PSP_PROVIDED,

    @SerialName(value = "stripe")
    STRIPE,

    @SerialName(value = "logpay")
    LOGPAY,

    @SerialName(value = "public_transport_ticket")
    PUBLIC_TRANSPORT_TICKET,

    @SerialName(value = "service_credits")
    SERVICE_CREDITS,

    @SerialName(value = "pos_payment")
    POS_PAYMENT,
    UNSUPPORTED,
}

internal object ApiPaymentMethodTypeSerializer : KSerializer<ApiPaymentMethodType> {
    override val descriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): ApiPaymentMethodType {
        return when (decoder.decodeString()) {
            "cash" -> ApiPaymentMethodType.CASH
            "psp_provided" -> ApiPaymentMethodType.PSP_PROVIDED
            "stripe" -> ApiPaymentMethodType.STRIPE
            "logpay" -> ApiPaymentMethodType.LOGPAY
            "public_transport_ticket" -> ApiPaymentMethodType.PUBLIC_TRANSPORT_TICKET
            "service_credits" -> ApiPaymentMethodType.SERVICE_CREDITS
            "pos_payment" -> ApiPaymentMethodType.POS_PAYMENT
            else -> ApiPaymentMethodType.UNSUPPORTED
        }
    }

    override fun serialize(encoder: Encoder, value: ApiPaymentMethodType) {
        encoder.encodeString(
            when (value) {
                ApiPaymentMethodType.CASH -> "cash"
                ApiPaymentMethodType.PSP_PROVIDED -> "psp_provided"
                ApiPaymentMethodType.STRIPE -> "stripe"
                ApiPaymentMethodType.LOGPAY -> "logpay"
                ApiPaymentMethodType.PUBLIC_TRANSPORT_TICKET -> "public_transport_ticket"
                ApiPaymentMethodType.SERVICE_CREDITS -> "service_credits"
                ApiPaymentMethodType.POS_PAYMENT -> "pos_payment"
                ApiPaymentMethodType.UNSUPPORTED -> "unsupported"
            },
        )
    }
}
