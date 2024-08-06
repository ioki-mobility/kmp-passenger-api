package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiStationsRequest(
    @SerialName(value = "product_id") val productId: String,
    val query: String,
    val xmin: Float? = null,
    val ymin: Float? = null,
    val xmax: Float? = null,
    val ymax: Float? = null,
)
