package com.ioki.passenger.api.test

import com.ioki.passenger.api.TipService
import com.ioki.passenger.api.models.ApiCreateTipRequest
import com.ioki.passenger.api.models.ApiTipResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeTipService : TipService {
    override suspend fun sendTip(rideId: String, request: ApiCreateTipRequest): ApiResult<ApiTipResponse> =
        error("Not overridden")
}
