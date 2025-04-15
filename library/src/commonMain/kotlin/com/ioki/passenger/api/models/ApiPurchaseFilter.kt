package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiPurchaseFilter(
    @SerialName(value = "purchasable_id") val purchasableId: String? = null,
    @SerialName(value = "purchasable_type") val purchasableType: ApiPurchasableType? = null,
    val state: ApiPurchaseState? = null,
    val page: String,
    val since: Instant? = null,
    val until: Instant? = null,
    val filter: ApiPurchaseType? = null,
    val order: Order? = null,
    @SerialName(value = "order_by") val orderBy: OrderBy? = null,
    @SerialName(value = "per_page") val perPage: String? = null,
) {
    @Serializable(ApiPurchaseFilterOrderSerializer::class)
    public enum class Order {
        @SerialName(value = "asc")
        ASCENDING,

        @SerialName(value = "desc")
        DESCENDING,
    }

    @Serializable(ApiPurchaseFilterOrderBySerializer::class)
    public enum class OrderBy {
        @SerialName(value = "created_at")
        CREATED_AT,

        @SerialName(value = "updated_at")
        UPDATED_AT,
    }
}

internal object ApiPurchaseFilterOrderSerializer :
    KSerializer<ApiPurchaseFilter.Order> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPurchaseFilter.Order) {
        encoder.encodeString(
            when (value) {
                ApiPurchaseFilter.Order.ASCENDING -> "asc"
                ApiPurchaseFilter.Order.DESCENDING -> "desc"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPurchaseFilter.Order {
        val stringValue = decoder.decodeString()

        return when (stringValue) {
            "asc" -> ApiPurchaseFilter.Order.ASCENDING
            "desc" -> ApiPurchaseFilter.Order.DESCENDING
            else -> ApiPurchaseFilter.Order.ASCENDING
        }
    }
}

private object ApiPurchaseFilterOrderBySerializer :
    KSerializer<ApiPurchaseFilter.OrderBy> {
    override val descriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiPurchaseFilter.OrderBy) {
        encoder.encodeString(
            when (value) {
                ApiPurchaseFilter.OrderBy.CREATED_AT -> "created_at"
                ApiPurchaseFilter.OrderBy.UPDATED_AT -> "updated_at"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiPurchaseFilter.OrderBy {
        val stringValue = decoder.decodeString()

        return when (stringValue) {
            "created_at" -> ApiPurchaseFilter.OrderBy.CREATED_AT
            "updated_at" -> ApiPurchaseFilter.OrderBy.UPDATED_AT
            else -> ApiPurchaseFilter.OrderBy.CREATED_AT
        }
    }
}
