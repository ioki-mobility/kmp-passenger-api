package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiErrorBody

public fun createApiErrorBody(apiErrors: List<ApiErrorBody.ApiError> = emptyList()): ApiErrorBody = ApiErrorBody(
    apiErrors = apiErrors,
)
