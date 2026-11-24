package com.ioki.passenger.api.test

import com.ioki.passenger.api.PayoneService
import com.ioki.passenger.api.models.ApiPayoneType
import com.ioki.passenger.api.models.ApiPayoneUrlResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakePayoneService : PayoneService {
    override suspend fun getPayoneUrl(paymentMethodType: ApiPayoneType): ApiResult<ApiPayoneUrlResponse> =
        error("Not overridden")
}
