package com.ioki.passenger.api.test

import com.ioki.passenger.api.RideSeriesService
import com.ioki.passenger.api.models.ApiRideSeriesRequest
import com.ioki.passenger.api.models.ApiRideSeriesResponse
import com.ioki.passenger.api.result.ApiResult

public open class RideSeriesServiceFake : RideSeriesService {
    override suspend fun getRideSeries(rideSeriesId: String): ApiResult<ApiRideSeriesResponse> = error(
        "Not overridden",
    )

    override suspend fun getRideSeriesList(page: Int): ApiResult<List<ApiRideSeriesResponse>> = error("Not overridden")

    override suspend fun createRideSeries(
        rideId: String,
        request: ApiRideSeriesRequest,
    ): ApiResult<ApiRideSeriesResponse> = error("Not overridden")
}
