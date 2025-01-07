package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiTicketingShopConfigurationResponse(
    @SerialName(value = "purchase_options") val purchaseOptions: List<ApiTicketingProductOption>,
)

