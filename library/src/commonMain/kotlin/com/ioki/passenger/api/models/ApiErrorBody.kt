package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiErrorBody(
    @SerialName(value = "api_errors") val apiErrors: List<ApiError> = emptyList(),
) {
    @Serializable
    public data class ApiError(val message: String, val code: String)
}
