package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiSettleDebitRequest(
    @SerialName(value = "payment_method") val paymentMethod: PurchasePaymentMethod,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
)

@Serializable
public data class PurchasePaymentMethod(
    @SerialName(value = "payment_method_type") val paymentMethodType: ApiPaymentMethodType,
    val id: String,
)
