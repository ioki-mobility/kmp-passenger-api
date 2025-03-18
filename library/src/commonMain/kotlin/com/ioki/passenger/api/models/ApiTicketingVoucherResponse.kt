package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiTicketingVoucherResponse(
    val id: String,
    val state: State = State.UNSUPPORTED,
    val price: ApiMoney,
    @SerialName(value = "product")
    val product: ApiTicketingProductResponse?,
    val ticket: Ticket?,
    @SerialName(value = "renewal_information") val renewalInformation: RenewalInformation,
) {
    @Serializable
    public enum class State {
        @SerialName(value = "initiated")
        INITIATED,

        @SerialName(value = "cancelled")
        CANCELLED,

        @SerialName(value = "issued")
        ISSUED,

        @SerialName(value = "redeemed")
        REDEEMED,
        UNSUPPORTED,
    }

    @Serializable
    public data class Ticket(
        val id: String,
        @SerialName(value = "webview_url") val webviewUrl: String?,
        @SerialName(value = "validity_information") val validityInformation: String,
        @SerialName(value = "valid_from") val validFrom: Instant?,
        @SerialName(value = "valid_until") val validUntil: Instant?,
        @SerialName(value = "vendor_ticket_details") val vendorTicketDetails: VendorTicketDetails?,
    ) {
        @Serializable
        public data class VendorTicketDetails(
            @SerialName(value = "customer_code") val customerCode: String,
            @SerialName(value = "full_name") val fullName: String,
            val host: String,
            val issuer: String,
            @SerialName(value = "purchase_id") val purchaseId: String,
        )
    }

    @Serializable
    public data class RenewalInformation(
        val renewable: Boolean,
        @SerialName(value = "valid_from") val validFrom: Instant?,
        @SerialName(value = "valid_until") val validUntil: Instant?,
    )
}
