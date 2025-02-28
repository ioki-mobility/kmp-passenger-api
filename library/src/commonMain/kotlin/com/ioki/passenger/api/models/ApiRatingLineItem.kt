package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRatingLineItem(
    @SerialName(value = "criterion_slug") val criterionSlug: String,
    val value: Int,
)
