package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaypalClientTokenResponse

public fun createApiPaypalClientTokenResponse(clientToken: String = ""): ApiPaypalClientTokenResponse =
    ApiPaypalClientTokenResponse(clientToken = clientToken)
