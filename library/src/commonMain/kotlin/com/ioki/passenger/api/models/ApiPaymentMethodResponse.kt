package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiPaymentMethodResponse.Summary.Kind
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiPaymentMethodResponse(
    @SerialName(value = "payment_method_type")
    val paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    val id: String?,
    val summary: Summary?,
) {
    @Serializable
    public data class Summary(
        val kind: Kind = Kind.UNSUPPORTED,
        val title: String,
        val expiration: String?,
        @SerialName(value = "mandate_url")
        val mandateUrl: String?,
    ) {
        @Serializable(with = ApiPaymentMethodResponseKindSerializer::class)
        public enum class Kind {
            @SerialName(value = "card")
            CREDIT_CARD,

            @SerialName(value = "sepa_debit")
            SEPA_DEBIT,

            @SerialName(value = "paypal")
            PAYPAL,

            @SerialName(value = "cash")
            CASH,

            @SerialName(value = "service_credits")
            SERVICE_CREDITS,

            @SerialName(value = "pos_payment")
            POS_PAYMENT,

            @SerialName(value = "external_payment")
            EXTERNAL_PAYMENT,

            UNSUPPORTED,
        }
    }
}

internal object ApiPaymentMethodResponseKindSerializer : KSerializer<Kind> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Kind) {
        encoder.encodeString(
            when (value) {
                Kind.CREDIT_CARD -> "card"
                Kind.SEPA_DEBIT -> "sepa_debit"
                Kind.PAYPAL -> "paypal"
                Kind.CASH -> "cash"
                Kind.SERVICE_CREDITS -> "service_credits"
                Kind.POS_PAYMENT -> "pos_payment"
                Kind.EXTERNAL_PAYMENT -> "external_payment"
                Kind.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): Kind {
        return when (decoder.decodeString()) {
            "card" -> Kind.CREDIT_CARD
            "sepa_debit" -> Kind.SEPA_DEBIT
            "paypal" -> Kind.PAYPAL
            "cash" -> Kind.CASH
            "service_credits" -> Kind.SERVICE_CREDITS
            "pos_payment" -> Kind.POS_PAYMENT
            "external_payment" -> Kind.EXTERNAL_PAYMENT
            else -> Kind.UNSUPPORTED
        }
    }
}
