package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiBootstrapResponse(
    val provider: ApiProvider,
    val products: List<ApiProduct>,
    val client: ApiClientInfoResponse,
    @SerialName(value = "rides_with_failed_payments") val ridesWithFailedPayments: List<ApiRideResponse>,
    @SerialName(value = "renewable_ticketing_vouchers")
    val renewableTicketingVouchers: List<ApiTicketingVoucherResponse>,
    @SerialName(value = "product_support_uris") val productSupportUris: List<ProductSupportUri>,
) {
    @Serializable
    public data class ProductSupportUri(
        @SerialName(value = "product_id") val productId: String,
        @SerialName(value = "support_website_uri") val supportWebsiteUri: String,
    )
}
