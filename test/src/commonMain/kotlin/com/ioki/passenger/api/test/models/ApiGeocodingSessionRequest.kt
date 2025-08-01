package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingSessionRequest

public fun createApiGeocodingSessionRequest(productId: String = ""): ApiGeocodingSessionRequest =
    ApiGeocodingSessionRequest(productId = productId)
