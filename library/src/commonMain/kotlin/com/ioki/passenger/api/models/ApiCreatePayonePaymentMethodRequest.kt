package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCreatePayonePaymentMethodRequest(
    @SerialName(value = "payment_method_type")
    val type: ApiPayoneType,
)
