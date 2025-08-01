package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed class ApiFailedPaymentResponse {
    @Serializable
    @SerialName("ride_payment_recovery")
    public data class PaymentRecovery(
        val id: String,
        @SerialName(value = "created_at") val createdAt: Instant,
        @SerialName(value = "updated_at") val updatedAt: Instant,
        @SerialName(value = "amount") val amount: ApiMoney,
        val rides: List<ApiRideResponse>,
        @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodResponse,
    ) : ApiFailedPaymentResponse()

    @Serializable
    @SerialName("stripe/payment_intent")
    public data class StripeIntent(
        val id: String,
        @SerialName(value = "client_secret") val clientSecret: String,
        @SerialName(value = "payment_method") val paymentMethod: String,
    ) : ApiFailedPaymentResponse()

    @Serializable
    @SerialName("unknown")
    public data object Unknown : ApiFailedPaymentResponse()
}
