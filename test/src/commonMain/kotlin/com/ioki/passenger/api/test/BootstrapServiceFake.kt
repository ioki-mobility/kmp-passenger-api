package com.ioki.passenger.api.test

import com.ioki.passenger.api.BootstrapService
import com.ioki.passenger.api.models.ApiBootstrapResponse
import com.ioki.passenger.api.result.ApiResult

public open class BootstrapServiceFake : BootstrapService {
    override suspend fun getBootstrap(): ApiResult<ApiBootstrapResponse> = error("Not overridden")
}
