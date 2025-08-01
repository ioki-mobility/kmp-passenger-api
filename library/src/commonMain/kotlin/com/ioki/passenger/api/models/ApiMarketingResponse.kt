package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiMarketingResponse(
    val id: String,
    @SerialName(value = "created_at")
    val createdAt: Instant,
    @SerialName(value = "updated_at")
    val updatedAt: Instant,
    val type: String,
    val user: ApiAuthenticatedUserResponse,
)
