package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdatePaymentMethodForRideRequest(
    @SerialName(value = "ride_version")
    val rideVersion: Int,
    @SerialName(value = "paypal_secure_element")
    val paypalSecureElement: String?,
    @SerialName(value = "payment_method")
    val paymentMethod: ApiPaymentMethodRequest,
)
