package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPassengerSelectionRequest(
    val type: String,
    val options: List<ApiOption>,
    @SerialName(value = "first_name")
    val firstName: String?,
    @SerialName(value = "last_name")
    val lastName: String?,
)
