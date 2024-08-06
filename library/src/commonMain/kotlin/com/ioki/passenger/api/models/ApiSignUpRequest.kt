package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiSignUpRequest(
    @SerialName(value = "first_name") val firstName: String,
    @SerialName(value = "last_name") val lastName: String,
    @SerialName(value = "terms_accepted") val termsAccepted: Boolean,
    @SerialName(value = "minimum_age_confirmed") val minimumAgeConfirmed: Boolean?,
    val email: ApiEmail,
    val version: Int,
)
