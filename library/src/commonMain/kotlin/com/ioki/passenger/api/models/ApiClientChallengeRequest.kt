package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiClientChallengeRequest(val solution: String, val nonce: String)
