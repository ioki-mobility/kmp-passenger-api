package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRatingRequest(
    @SerialName(value = "ride_version") val rideVersion: Int,
    @SerialName(value = "rating_line_items") val ratingLineItems: List<ApiRatingLineItem>,
    val comment: String?,
)
