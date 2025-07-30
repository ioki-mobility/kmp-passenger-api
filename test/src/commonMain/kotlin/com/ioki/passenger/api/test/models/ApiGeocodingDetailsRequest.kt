package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingDetailsRequest

public fun createApiGeocodingDetailsRequest(id: String = ""): ApiGeocodingDetailsRequest =
    ApiGeocodingDetailsRequest(id = id)
