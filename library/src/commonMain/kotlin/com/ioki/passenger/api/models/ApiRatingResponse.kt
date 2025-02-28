package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRatingResponse(
    val id: String,
    val comment: String?,
    @SerialName(value = "rating_line_items") val ratingLineItems: List<ApiRatingLineItem>,
)
