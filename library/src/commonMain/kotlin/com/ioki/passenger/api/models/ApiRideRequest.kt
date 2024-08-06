package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideRequest(
    @SerialName(value = "product_id") val productId: String,
    @SerialName(value = "passengers") val passengers: List<ApiPassengerSelectionRequest>,
    @SerialName(value = "options") val options: List<ApiOption>,
    val origin: ApiLocation,
    val destination: ApiLocation,
)
