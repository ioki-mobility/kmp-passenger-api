package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRequestTokenResponse

public fun createApiRequestTokenResponse(
    id: String = "",
    type: String = "",
    token: String = "",
    userId: String = "",
): ApiRequestTokenResponse = ApiRequestTokenResponse(
    id = id,
    type = type,
    token = token,
    userId = userId,
)
