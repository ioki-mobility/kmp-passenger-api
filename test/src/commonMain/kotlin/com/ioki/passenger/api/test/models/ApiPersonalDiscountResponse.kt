package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse
import kotlinx.datetime.Instant

public fun createApiPersonalDiscountResponse(
    id: String = "",
    title: String = "",
    description: String = "",
    channel: ApiPersonalDiscountResponse.Channel = ApiPersonalDiscountResponse.Channel.UNSUPPORTED,
    validFrom: Instant? = null,
    validUntil: Instant? = null,
    maximumUsages: Int? = null,
    usages: Int? = null,
    discountType: ApiPersonalDiscountResponse.DiscountType = ApiPersonalDiscountResponse.DiscountType.UNSUPPORTED,
    relativeDiscount: Int? = null,
    absoluteDiscount: ApiMoney? = null,
    fixedPricePerPassenger: ApiMoney? = null,
    fixedPricePerRide: ApiMoney? = null,
    validity: ApiPersonalDiscountResponse.Validity = ApiPersonalDiscountResponse.Validity.UNSUPPORTED,
    redeemedPromoCodeId: String? = null,
): ApiPersonalDiscountResponse = ApiPersonalDiscountResponse(
    id = id,
    title = title,
    description = description,
    channel = channel,
    validFrom = validFrom,
    validUntil = validUntil,
    maximumUsages = maximumUsages,
    usages = usages,
    discountType = discountType,
    relativeDiscount = relativeDiscount,
    absoluteDiscount = absoluteDiscount,
    fixedPricePerPassenger = fixedPricePerPassenger,
    fixedPricePerRide = fixedPricePerRide,
    validity = validity,
    redeemedPromoCodeId = redeemedPromoCodeId,
)
