package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiGeocodingSessionRequest(@SerialName(value = "product_id") val productId: String)
