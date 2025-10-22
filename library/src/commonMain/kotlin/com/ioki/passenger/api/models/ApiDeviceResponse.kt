package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiDeviceResponse(val id: String, val token: String)
