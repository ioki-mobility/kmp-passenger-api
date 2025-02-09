package com.ioki.passenger.api.test

import com.ioki.passenger.api.StationsService
import com.ioki.passenger.api.models.ApiStationResponse
import com.ioki.passenger.api.models.ApiStationsRequest
import com.ioki.passenger.api.result.ApiResult

public open class StationsServiceFake : StationsService {
    override suspend fun getStations(request: ApiStationsRequest): ApiResult<List<ApiStationResponse>> =
        error("Not overridden")
}
