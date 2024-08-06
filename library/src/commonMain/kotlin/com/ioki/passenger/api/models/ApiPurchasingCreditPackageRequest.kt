package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPurchasingCreditPackageRequest(
    val cost: Int,
    val value: Int,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodRequest,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
)
