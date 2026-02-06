package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPaymentMethodCreationRequest(
    @SerialName(value = "payment_method_type") val paymentMethodType: String,
    val attached: Boolean,
    val details: Details,
) {
    @Serializable
    public data class Details(
        @SerialName(value = "stripe_payment_method_id") val stripePaymentMethodId: String?,
        @SerialName(value = "braintree_nonce") val braintreeNonce: String?,
        @SerialName(value = "paypal_secure_element") val paypalSecureElement: String?,
    )
}
