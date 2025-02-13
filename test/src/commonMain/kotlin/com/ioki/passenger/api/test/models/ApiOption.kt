package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.AnyValue
import com.ioki.passenger.api.models.ApiOption

public fun createApiOption(slug: String = "", value: AnyValue = AnyValue.IntValue(0)): ApiOption = ApiOption(
    slug = slug,
    value = value,
)
