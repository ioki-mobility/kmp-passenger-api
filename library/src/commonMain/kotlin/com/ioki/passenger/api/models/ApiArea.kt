package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiArea(
    val type: String,
    val coordinates: List<List<List<List<Double>>>>,
) {
    override fun toString(): String {
        return "ApiArea(type='$type', hash=${coordinates.hashCode()})"
    }
}
