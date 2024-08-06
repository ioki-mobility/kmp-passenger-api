package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPersonalDiscountPurchaseRequest(
    @SerialName(value = "personal_discount_type_id")
    val personalDiscountTypeId: String,
    @SerialName(value = "payment_method")
    val paymentMethod: ApiPaymentMethodRequest,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
    @SerialName(value = "valid_from") val validFromDate: String?,
)
