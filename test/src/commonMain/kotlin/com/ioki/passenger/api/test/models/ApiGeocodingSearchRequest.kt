package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingSearchRequest

public fun createApiGeocodingSearchRequest(
    query: String = "",
    productId: String = "",
    placeTypes: String = "",
): ApiGeocodingSearchRequest = ApiGeocodingSearchRequest(
    query = query,
    productId = productId,
    placeTypes = placeTypes,
)
