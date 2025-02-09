package com.ioki.passenger.api.test

import com.ioki.passenger.api.LogPayService
import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiLogPayUrlResponse
import com.ioki.passenger.api.result.ApiResult

public open class LogPayServiceFake : LogPayService {
    override suspend fun createLogPayCustomer(request: ApiLogPayAccountRequest): ApiResult<ApiLogPayUrlResponse> =
        error("Not overridden")

    override suspend fun getLogPayUrl(paymentMethodType: ApiLogPayType): ApiResult<ApiLogPayUrlResponse> =
        error("Not overridden")
}
