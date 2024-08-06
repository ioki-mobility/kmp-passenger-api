package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ApiLogPayType {
    @SerialName(value = "card")
    CARD,

    @SerialName(value = "sepa_debit")
    SEPA_DEBIT,

    @SerialName(value = "paypal")
    PAYPAL,
    UNSUPPORTED,
}
