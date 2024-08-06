package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCreateLogPayPaymentMethodRequest(
    @SerialName(value = "payment_method_type")
    val type: ApiLogPayType = ApiLogPayType.UNSUPPORTED,
)
