package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCreateTipRequest(
    val amount: Int,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodRequest,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
)
