package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPurchaseTicketingProductRequest(
    @SerialName(value = "ride_id")
    val rideId: String?,
    @SerialName(value = "purchase_options")
    val purchaseOptions: List<Option>,
    @SerialName(value = "redemption_options")
    val redemptionOptions: List<Option>,
    @SerialName(value = "payment_method")
    val paymentMethod: ApiPaymentMethodRequest,
    @SerialName(value = "paypal_secure_element")
    val paypalSecureElement: String?,
) {
    @Serializable
    public data class Option(val slug: String, val value: AnyValue)
}
