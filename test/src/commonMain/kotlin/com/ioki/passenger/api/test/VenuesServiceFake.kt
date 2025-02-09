package com.ioki.passenger.api.test

import com.ioki.passenger.api.VenuesService
import com.ioki.passenger.api.models.ApiVenueResponse
import com.ioki.passenger.api.result.ApiResult

public open class VenuesServiceFake : VenuesService {
    override suspend fun getVenues(): ApiResult<List<ApiVenueResponse>> = error("Not overridden")
}
