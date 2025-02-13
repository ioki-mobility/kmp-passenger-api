package com.ioki.passenger.api.test

import com.ioki.passenger.api.MarketingService
import com.ioki.passenger.api.models.ApiMarketingResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeMarketingService : MarketingService {
    override suspend fun marketingApproval(): ApiResult<ApiMarketingResponse> = error("Not overridden")

    override suspend fun marketingRejection(): ApiResult<ApiMarketingResponse> = error("Not overridden")
}
