package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiFareResponse(
    override val id: String,
    override val version: Int,
    @SerialName(value = "booking_price") val bookingPrice: ApiMoney,
    @SerialName(value = "booking_price_type")
    val bookingPriceType: BookingPriceType = BookingPriceType.UNSUPPORTED,
    @SerialName(value = "final_price") val finalPrice: ApiMoney?,
    @SerialName(value = "custom_message_for_external_pricing") val externalPricingCustomMessage: String?,
) : Entity {
    @Serializable
    public enum class BookingPriceType {
        @SerialName(value = "fixed")
        FIXED,

        @SerialName(value = "max")
        MAX,

        @SerialName(value = "estimate")
        ESTIMATE,
        UNSUPPORTED,
    }
}
