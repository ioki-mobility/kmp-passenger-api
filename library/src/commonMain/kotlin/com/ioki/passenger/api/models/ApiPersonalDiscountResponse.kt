package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiPersonalDiscountResponse.Channel
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse.DiscountType
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse.Validity
import kotlin.time.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
    @Serializable(ApiPersonalDiscountResponseChannelSerializer::class)
    public enum class Channel {
        @SerialName(value = "purchased")
        PURCHASED,

        @SerialName(value = "promotion")
        PROMOTION,

        @SerialName(value = "referral")
        REFERRAL,

        @SerialName(value = "operator_assigned")
        OPERATOR_ASSIGNED,

        @SerialName(value = "operator_assigned_legacy")
        OPERATOR_ASSIGNED_LEGACY,

        @SerialName(value = "assigned_for_good_will")
        ASSIGNED_FOR_GOOD_WILL,

        @SerialName(value = "assigned_for_promotion")
        ASSIGNED_FOR_PROMOTION,

        @SerialName(value = "assigned_for_other_reason")
        ASSIGNED_FOR_OTHER_REASON,

        @SerialName(value = "sold_by_operator")
        SOLD_BY_OPERATOR,

        UNSUPPORTED,
    }

    @Serializable(ApiPersonalDiscountResponseDiscountTypeSerializer::class)
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

    @Serializable(ApiPersonalDiscountResponseValiditySerializer::class)
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

private object ApiPersonalDiscountResponseChannelSerializer : KSerializer<Channel> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Channel) {
        encoder.encodeString(
            when (value) {
                Channel.PURCHASED -> "purchased"
                Channel.PROMOTION -> "promotion"
                Channel.REFERRAL -> "referral"
                Channel.OPERATOR_ASSIGNED -> "operator_assigned"
                Channel.OPERATOR_ASSIGNED_LEGACY -> "operator_assigned_legacy"
                Channel.ASSIGNED_FOR_GOOD_WILL -> "assigned_for_good_will"
                Channel.ASSIGNED_FOR_PROMOTION -> "assigned_for_promotion"
                Channel.ASSIGNED_FOR_OTHER_REASON -> "assigned_for_other_reason"
                Channel.SOLD_BY_OPERATOR -> "sold_by_operator"
                Channel.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): Channel = when (decoder.decodeString()) {
        "purchased" -> Channel.PURCHASED
        "promotion" -> Channel.PROMOTION
        "referral" -> Channel.REFERRAL
        "operator_assigned" -> Channel.OPERATOR_ASSIGNED
        "operator_assigned_legacy" -> Channel.OPERATOR_ASSIGNED_LEGACY
        "assigned_for_good_will" -> Channel.ASSIGNED_FOR_GOOD_WILL
        "assigned_for_promotion" -> Channel.ASSIGNED_FOR_PROMOTION
        "assigned_for_other_reason" -> Channel.ASSIGNED_FOR_OTHER_REASON
        "sold_by_operator" -> Channel.SOLD_BY_OPERATOR
        else -> Channel.UNSUPPORTED
    }
}

private object ApiPersonalDiscountResponseDiscountTypeSerializer : KSerializer<DiscountType> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: DiscountType) {
        encoder.encodeString(
            when (value) {
                DiscountType.ABSOLUTE -> "absolute"
                DiscountType.RELATIVE -> "relative"
                DiscountType.FIXED_PER_PASSENGER -> "fixed_per_passenger"
                DiscountType.FIXED_PER_RIDE -> "fixed_per_ride"
                DiscountType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): DiscountType = when (decoder.decodeString()) {
        "absolute" -> DiscountType.ABSOLUTE
        "relative" -> DiscountType.RELATIVE
        "fixed_per_passenger" -> DiscountType.FIXED_PER_PASSENGER
        "fixed_per_ride" -> DiscountType.FIXED_PER_RIDE
        else -> DiscountType.UNSUPPORTED
    }
}

private object ApiPersonalDiscountResponseValiditySerializer : KSerializer<Validity> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Validity) {
        encoder.encodeString(
            when (value) {
                Validity.USAGE -> "usage"
                Validity.TIME -> "time"
                Validity.USAGE_AND_TIME -> "usage_and_time"
                Validity.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): Validity = when (decoder.decodeString()) {
        "usage" -> Validity.USAGE
        "time" -> Validity.TIME
        "usage_and_time" -> Validity.USAGE_AND_TIME
        else -> Validity.UNSUPPORTED
    }
}
