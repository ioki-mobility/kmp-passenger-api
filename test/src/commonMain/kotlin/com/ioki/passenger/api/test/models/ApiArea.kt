package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiArea

public fun createApiArea(type: String = "", coordinates: List<List<List<List<Double>>>> = emptyList()): ApiArea =
    ApiArea(
        type = type,
        coordinates = coordinates,
    )
