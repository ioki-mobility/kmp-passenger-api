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
    @SerialName(value = "show_custom_message") val showCustomMessage: Boolean,
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
