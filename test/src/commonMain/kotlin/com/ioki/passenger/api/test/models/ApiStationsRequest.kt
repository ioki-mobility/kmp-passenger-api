package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiStationsRequest

public fun createApiStationsRequest(
    productId: String = "",
    query: String = "",
    xmin: Float? = null,
    ymin: Float? = null,
    xmax: Float? = null,
    ymax: Float? = null,
): ApiStationsRequest = ApiStationsRequest(
    productId = productId,
    query = query,
    xmin = xmin,
    ymin = ymin,
    xmax = xmax,
    ymax = ymax,
)
