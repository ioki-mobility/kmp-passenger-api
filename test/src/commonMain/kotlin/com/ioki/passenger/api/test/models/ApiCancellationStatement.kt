package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCancellationStatement

public fun createApiCancellationStatement(
    id: String = "",
    title: String = "",
    suitableForRideSeries: Boolean = false,
    suitableForSingleRides: Boolean = false,
): ApiCancellationStatement = ApiCancellationStatement(
    id = id,
    title = title,
    suitableForRideSeries = suitableForRideSeries,
    suitableForSingleRides = suitableForSingleRides,
)
