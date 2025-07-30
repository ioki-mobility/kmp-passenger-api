package com.ioki.passenger.api.test

import com.ioki.passenger.api.GeocodingService
import com.ioki.passenger.api.models.ApiGeocodingDetailsRequest
import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse
import com.ioki.passenger.api.models.ApiGeocodingSearchRequest
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse
import com.ioki.passenger.api.models.ApiGeocodingSessionRequest
import com.ioki.passenger.api.models.ApiGeocodingSessionResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeGeocodingService : GeocodingService {
    override suspend fun getGeocodingSession(
        request: ApiGeocodingSessionRequest,
    ): ApiResult<ApiGeocodingSessionResponse> = error("Not overridden")

    override suspend fun expireGeocodingSession(sessionId: String): ApiResult<Unit> = error("Not overridden")

    override suspend fun getGeocodingSearch(
        sessionId: String,
        request: ApiGeocodingSearchRequest,
    ): ApiResult<ApiGeocodingSearchResponse> = error("Not overridden")

    override suspend fun getGeocodingDetails(
        sessionId: String,
        request: ApiGeocodingDetailsRequest,
    ): ApiResult<ApiGeocodingDetailsResponse> = error("Not overridden")
}
