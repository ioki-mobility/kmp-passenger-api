package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiDeviceResponse

public fun createApiDeviceResponse(id: String = "", token: String = ""): ApiDeviceResponse = ApiDeviceResponse(
    id = id,
    token = token,
)
