package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiBody<out T>(val data: T, val meta: Meta? = null) {
    @Serializable
    public data class Meta(val page: Int, @SerialName(value = "last_page") val lastPage: Boolean)
}
