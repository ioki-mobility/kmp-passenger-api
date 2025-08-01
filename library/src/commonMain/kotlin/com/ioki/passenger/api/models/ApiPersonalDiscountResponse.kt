package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPersonalDiscountResponse(
    val id: String,
    val title: String,
    val description: String,
    val channel: Channel = Channel.UNSUPPORTED,
    @SerialName(value = "valid_from")
    val validFrom: Instant?,
    @SerialName(value = "valid_until")
    val validUntil: Instant?,
    @SerialName(value = "maximum_usages")
    val maximumUsages: Int?,
    val usages: Int?,
    @SerialName(value = "discount_type")
    val discountType: DiscountType = DiscountType.UNSUPPORTED,
    @SerialName(value = "relative_discount")
    val relativeDiscount: Int?,
    @SerialName(value = "absolute_discount")
    val absoluteDiscount: ApiMoney?,
    @SerialName(value = "fixed_price_per_passenger")
    val fixedPricePerPassenger: ApiMoney?,
    @SerialName(value = "fixed_price_per_ride")
    val fixedPricePerRide: ApiMoney?,
    val validity: Validity = Validity.UNSUPPORTED,
    @SerialName(value = "redeemed_promo_code_id")
    val redeemedPromoCodeId: String?,
) {
    @Serializable
    public enum class Channel {
        @SerialName(value = "purchased")
        PURCHASED,

        @SerialName(value = "promotion")
        PROMOTION,

        @SerialName(value = "referral")
        REFERRAL,

        @SerialName(value = "operator_assigned")
        OPERATOR_ASSIGNED,
        UNSUPPORTED,
    }

    @Serializable
    public enum class DiscountType {
        @SerialName(value = "absolute")
        ABSOLUTE,

        @SerialName(value = "relative")
        RELATIVE,

        @SerialName(value = "fixed_per_passenger")
        FIXED_PER_PASSENGER,

        @SerialName(value = "fixed_per_ride")
        FIXED_PER_RIDE,
        UNSUPPORTED,
    }

    @Serializable
    public enum class Validity {
        @SerialName(value = "usage")
        USAGE,

        @SerialName(value = "time")
        TIME,

        @SerialName(value = "usage_and_time")
        USAGE_AND_TIME,
        UNSUPPORTED,
    }
}
