package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PassengerApiArea(
    val type: String,
    val id: String?,
    val name: String,
    val slug: String,
    @SerialName(value = "area_type") val areaType: String,
    val color: String,
    val opacity: Float,
    @SerialName(value = "stroke_weight") val strokeWeight: Int,
    @SerialName(value = "fill_color") val fillColor: String,
    @SerialName(value = "fill_opacity") val fillOpacity: Float,
    val invert: Boolean,
    @SerialName(value = "z_index") val zIndex: Int,
    @SerialName(value = "legend_index") val legendIndex: Int,
    @SerialName(value = "legend_title") val legendTitle: String?,
    @SerialName(value = "legend_description") val legendDescription: String?,
    val area: ApiArea,
)
