package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
public data class ApiUserLocationsRequest(
    val page: Int,
    val since: Instant? = null,
    val until: Instant? = null,
    val order: Order? = null,
    @SerialName(value = "order_by") val orderBy: OrderBy? = null,
    @SerialName(value = "per_page") val perPage: Int? = null,
) {
    @Serializable
    public enum class Order {
        @SerialName(value = "asc")
        ASCENDING,

        @SerialName(value = "desc")
        DESCENDING,
    }

    @Serializable
    public enum class OrderBy {
        @SerialName(value = "created_at")
        CREATED_AT,

        @SerialName(value = "updated_at")
        UPDATED_AT,
    }
}
