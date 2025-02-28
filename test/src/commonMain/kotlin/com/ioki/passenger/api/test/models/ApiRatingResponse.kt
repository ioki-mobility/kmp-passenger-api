package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingLineItem
import com.ioki.passenger.api.models.ApiRatingResponse

public fun createApiRatingResponse(
    id: String = "",
    ratingLineItems: List<ApiRatingLineItem> = emptyList(),
    comment: String? = null,
): ApiRatingResponse = ApiRatingResponse(
    id = id,
    ratingLineItems = ratingLineItems,
    comment = comment,
)
