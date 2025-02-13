package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiTicketingProductOption
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import kotlinx.datetime.Instant

public fun createApiTicketingProductResponse(
    id: String? = null,
    type: String = "",
    createdAt: Instant? = null,
    updatedAt: Instant = Instant.DISTANT_PAST,
    providerId: String = "",
    ticketingVendorId: String = "",
    slug: String = "",
    name: String = "",
    description: String = "",
    purchasable: Boolean = false,
    purchasableFrom: Instant? = null,
    purchasableUntil: Instant? = null,
    priceType: ApiTicketingProductResponse.PriceType = ApiTicketingProductResponse.PriceType.UNSUPPORTED,
    price: ApiMoney? = null,
    purchaseOptions: List<ApiTicketingProductOption> = emptyList(),
    redemptionOptions: List<ApiTicketingProductOption> = emptyList(),
): ApiTicketingProductResponse = ApiTicketingProductResponse(
    id = id,
    type = type,
    createdAt = createdAt,
    updatedAt = updatedAt,
    providerId = providerId,
    ticketingVendorId = ticketingVendorId,
    slug = slug,
    name = name,
    description = description,
    purchasable = purchasable,
    purchasableFrom = purchasableFrom,
    purchasableUntil = purchasableUntil,
    priceType = priceType,
    price = price,
    purchaseOptions = purchaseOptions,
    redemptionOptions = redemptionOptions,
)
