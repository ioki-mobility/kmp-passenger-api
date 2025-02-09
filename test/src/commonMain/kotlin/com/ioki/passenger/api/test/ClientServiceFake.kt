package com.ioki.passenger.api.test

import com.ioki.passenger.api.ClientService
import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.result.ApiResult

public open class ClientServiceFake : ClientService {
    override suspend fun requestClientInfo(): ApiResult<ApiClientInfoResponse> = error("Not overridden")
}
