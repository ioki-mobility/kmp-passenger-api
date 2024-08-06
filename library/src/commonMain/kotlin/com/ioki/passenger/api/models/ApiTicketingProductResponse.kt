package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiTicketingProductResponse(
    val id: String?,
    val type: String,
    @SerialName(value = "created_at") val createdAt: Instant?,
    @SerialName(value = "updated_at") val updatedAt: Instant,
    @SerialName(value = "provider_id") val providerId: String,
    @SerialName(value = "ticketing_vendor_id") val ticketingVendorId: String,
    val slug: String,
    val name: String,
    val description: String,
    val purchasable: Boolean,
    @SerialName(value = "purchasable_from") val purchasableFrom: Instant?,
    @SerialName(value = "purchasable_until") val purchasableUntil: Instant?,
    @SerialName(value = "price_type") val priceType: PriceType = PriceType.UNSUPPORTED,
    val price: ApiMoney?,
    @SerialName(value = "purchase_options") val purchaseOptions: List<Option>,
    @SerialName(value = "redemption_options") val redemptionOptions: List<Option>,
) {
    @Serializable
    public enum class PriceType {
        @SerialName(value = "exact")
        EXACT,

        @SerialName(value = "min")
        MIN,
        UNSUPPORTED,
    }

    @Serializable
    public data class Option(
        val slug: String,
        val name: String,
        val description: String,
        @SerialName(value = "data_type") val dataType: DataType = DataType.UNSUPPORTED,
        @SerialName(value = "data_format") val dataFormat: DataFormat = DataFormat.UNSUPPORTED,
        @SerialName(value = "data_enum") val dataEnum: Boolean,
        @SerialName(value = "enum_items") val enumItems: List<EnumItem>,
        val required: Boolean,
    )

    @Serializable
    public data class EnumItem(
        val slug: String,
        val name: String,
        val description: String,
        val value: String,
    )

    @Serializable
    public enum class DataType {
        @SerialName(value = "boolean")
        BOOLEAN,

        @SerialName(value = "integer")
        INTEGER,

        @SerialName(value = "number")
        NUMBER,

        @SerialName(value = "string")
        STRING,
        UNSUPPORTED,
    }

    @Serializable
    public enum class DataFormat {
        @SerialName(value = "")
        EMPTY,

        @SerialName(value = "date")
        DATE,

        @SerialName(value = "datetime")
        DATETIME,
        UNSUPPORTED,
    }
}
