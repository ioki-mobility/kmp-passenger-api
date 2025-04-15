package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiFareResponse.LineItem
import com.ioki.passenger.api.models.ApiMoney

public fun createApiFareResponse(
    id: String = "",
    version: Int = 0,
    bookingPrice: ApiMoney = createApiMoney(),
    bookingPriceType: ApiFareResponse.BookingPriceType = ApiFareResponse.BookingPriceType.UNSUPPORTED,
    finalPrice: ApiMoney? = null,
    externalPricingCustomMessage: String? = null,
    lineItems: List<LineItem> = emptyList(),
): ApiFareResponse = ApiFareResponse(
    id = id,
    version = version,
    bookingPrice = bookingPrice,
    bookingPriceType = bookingPriceType,
    finalPrice = finalPrice,
    lineItems = lineItems,
    customMessageForExternalPricing = externalPricingCustomMessage,
)

public fun createApiFareResponseLineItem(
    position: Int = 0,
    quantity: Int = 0,
    description: String? = null,
    title: String? = null,
    amountGross: ApiMoney? = null,
    amountNet: ApiMoney? = null,
): LineItem = LineItem(
    position = position,
    quantity = quantity,
    description = description,
    title = title,
    amountGross = amountGross,
    amountNet = amountNet,
)
