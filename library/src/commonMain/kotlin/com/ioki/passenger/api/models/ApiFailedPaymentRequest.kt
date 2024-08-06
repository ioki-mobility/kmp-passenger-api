package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiFailedPaymentRequest(
    val amount: Int,
    @SerialName(value = "ride_ids") val rideIds: List<String>,
    @SerialName(value = "payment_method") val paymentMethod: PaymentMethod,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
) {
    @Serializable
    public data class PaymentMethod(
        @SerialName(value = "payment_method_type")
        val paymentMethodType: ApiPaymentMethodType,
        val id: String?,
    )
}
