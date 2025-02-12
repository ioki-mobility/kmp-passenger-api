package com.ioki.passenger.api.test

import com.ioki.passenger.api.PublicTransportService
import com.ioki.passenger.api.models.ApiScheduleResponse
import com.ioki.passenger.api.result.ApiResult
import kotlinx.datetime.Instant

public open class FakePublicTransportService : PublicTransportService {
    override suspend fun getPublicTransportSchedules(url: String, time: Instant): ApiResult<List<ApiScheduleResponse>> =
        error("Not overridden")
}
