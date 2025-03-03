package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingLineItem

public fun createApiRatingLineItem(criterionSlug: String = "", value: Int = 0): ApiRatingLineItem = ApiRatingLineItem(
    criterionSlug = criterionSlug,
    value = value,
)
