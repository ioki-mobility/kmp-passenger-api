package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiResettleDebitsRequest(
    @SerialName(value = "purchase_ids") val purchaseIds: List<String>,
    @SerialName(value = "payment_method") val paymentMethod: PurchasePaymentMethod,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
    val amount: Int,
)
