package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiFailedPaymentRequest(
    val amount: Int,
    @SerialName(value = "ride_ids") val rideIds: List<String>,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodRequest,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
)
