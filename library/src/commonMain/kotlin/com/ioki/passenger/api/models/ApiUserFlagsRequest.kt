package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUserFlagsRequest(
    val version: Int,
    @SerialName(value = "terms_accepted") val termsAccepted: Boolean?,
    @SerialName(value = "minimum_age_confirmed") val minimumAgeConfirmed: Boolean?,
    @SerialName(value = "analytics_tracking") val analyticsTracking: Boolean?,
)
