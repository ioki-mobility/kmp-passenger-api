package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdateUserRequest(
    val version: Int,
    @SerialName(value = "first_name") val firstName: String?,
    @SerialName(value = "last_name") val lastName: String?,
    val email: ApiEmail?,
    @SerialName(value = "terms_accepted") val termsAccepted: Boolean?,
    @SerialName(value = "analytics_tracking") val tracking: Boolean?,
    @SerialName(value = "additional_data") val additionalData: ApiAdditionalData?,
)
