package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPaypalClientTokenResponse(
    @SerialName(value = "client_token") val clientToken: String,
)
