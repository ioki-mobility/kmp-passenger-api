package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPaymentMethodRequest(
    @SerialName(value = "payment_method_type")
    val paymentMethodType: ApiPaymentMethodType,
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
        @Serializable
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
            UNSUPPORTED,
        }
    }
}
