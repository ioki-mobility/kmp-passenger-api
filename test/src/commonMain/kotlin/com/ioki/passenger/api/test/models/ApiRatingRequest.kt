package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingLineItem
import com.ioki.passenger.api.models.ApiRatingRequest

public fun createApiRatingRequest(
    rideVersion: Int = 0,
    ratingLineItems: List<ApiRatingLineItem> = emptyList(),
    comment: String? = null,
): ApiRatingRequest = ApiRatingRequest(
    rideVersion = rideVersion,
    ratingLineItems = ratingLineItems,
    comment = comment,
)
