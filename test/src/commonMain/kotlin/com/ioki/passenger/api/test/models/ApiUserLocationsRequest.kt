package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiUserLocationsRequest
import com.ioki.passenger.api.models.ApiUserLocationsRequest.Order
import com.ioki.passenger.api.models.ApiUserLocationsRequest.OrderBy
import kotlin.time.Instant

public fun createApiUserLocationsRequest(
    page: Int = 1,
    since: Instant? = null,
    until: Instant? = null,
    order: Order? = null,
    orderBy: OrderBy? = null,
    perPage: Int? = null,
): ApiUserLocationsRequest = ApiUserLocationsRequest(
    page = page,
    since = since,
    until = until,
    order = order,
    orderBy = orderBy,
    perPage = perPage,
)
