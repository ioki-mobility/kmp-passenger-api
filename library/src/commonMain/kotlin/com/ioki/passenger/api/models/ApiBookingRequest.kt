package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiBookingRequest(
    @SerialName(value = "ride_version") val rideVersion: Int,
    @SerialName(value = "solution_id") val solutionId: String?,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodRequest?,
    @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
)
