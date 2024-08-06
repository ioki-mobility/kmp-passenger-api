package com.ioki.passenger.api

import com.ioki.passenger.api.models.ApiErrorBody

public interface ApiErrorInterceptor {
    public fun intercept(apiErrors: List<ApiErrorBody.ApiError>, httpResponseCode: Int): Boolean
}
