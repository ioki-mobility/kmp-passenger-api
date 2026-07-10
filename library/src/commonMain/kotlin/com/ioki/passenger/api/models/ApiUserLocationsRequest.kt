package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
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
    @Serializable(with = ApiUserLocationsOrderSerializer::class)
    public enum class Order {
        @SerialName(value = "asc")
        ASCENDING,

        @SerialName(value = "desc")
        DESCENDING,
    }

    @Serializable(with = ApiUserLocationsOrderBySerializer::class)
    public enum class OrderBy {
        @SerialName(value = "created_at")
        CREATED_AT,

        @SerialName(value = "updated_at")
        UPDATED_AT,
    }
}

internal object ApiUserLocationsOrderSerializer : KSerializer<ApiUserLocationsRequest.Order> {
    override val descriptor: SerialDescriptor
        get() = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiUserLocationsRequest.Order) {
        encoder.encodeString(
            when (value) {
                ApiUserLocationsRequest.Order.ASCENDING -> "asc"
                ApiUserLocationsRequest.Order.DESCENDING -> "desc"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiUserLocationsRequest.Order {
        val stringValue = decoder.decodeString()

        return when (stringValue) {
            "asc" -> ApiUserLocationsRequest.Order.ASCENDING
            "desc" -> ApiUserLocationsRequest.Order.DESCENDING
            else -> ApiUserLocationsRequest.Order.ASCENDING
        }
    }
}

internal object ApiUserLocationsOrderBySerializer : KSerializer<ApiUserLocationsRequest.OrderBy> {
    override val descriptor: SerialDescriptor
        get() = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiUserLocationsRequest.OrderBy) {
        encoder.encodeString(
            when (value) {
                ApiUserLocationsRequest.OrderBy.CREATED_AT -> "created_at"
                ApiUserLocationsRequest.OrderBy.UPDATED_AT -> "updated_at"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiUserLocationsRequest.OrderBy {
        val stringValue = decoder.decodeString()

        return when (stringValue) {
            "created_at" -> ApiUserLocationsRequest.OrderBy.CREATED_AT
            "updated_at" -> ApiUserLocationsRequest.OrderBy.UPDATED_AT
            else -> ApiUserLocationsRequest.OrderBy.CREATED_AT
        }
    }
}
