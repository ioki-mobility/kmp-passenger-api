package com.ioki.passenger.api.models

import kotlin.time.Instant
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
    @SerialName(value = "purchase_options") val purchaseOptions: List<ApiTicketingProductOption>,
    @SerialName(value = "redemption_options") val redemptionOptions: List<ApiTicketingProductOption>,
) {
    @Serializable
    public enum class PriceType {
        @SerialName(value = "exact")
        EXACT,

        @SerialName(value = "min")
        MIN,
        UNSUPPORTED,
    }
}
