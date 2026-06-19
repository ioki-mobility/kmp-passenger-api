package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiRequestTokenRequest(val claim: String, val channel: ApiVerificationChannelType, val code: String)
