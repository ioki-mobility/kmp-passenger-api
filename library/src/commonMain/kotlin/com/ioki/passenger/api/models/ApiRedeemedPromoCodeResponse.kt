package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRedeemedPromoCodeResponse(
    val id: String,
    @SerialName(value = "created_at") val createdAt: Instant,
    val title: String,
    val description: String,
    val url: String?,
)
