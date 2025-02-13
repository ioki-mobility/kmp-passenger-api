package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiMoney

public fun createApiFareResponse(
    id: String = "",
    version: Int = 0,
    bookingPrice: ApiMoney = createApiMoney(),
    bookingPriceType: ApiFareResponse.BookingPriceType = ApiFareResponse.BookingPriceType.UNSUPPORTED,
    finalPrice: ApiMoney? = null,
    showCustomMessage: Boolean = false,
): ApiFareResponse = ApiFareResponse(
    id = id,
    version = version,
    bookingPrice = bookingPrice,
    bookingPriceType = bookingPriceType,
    finalPrice = finalPrice,
    showCustomMessage = showCustomMessage,
)
