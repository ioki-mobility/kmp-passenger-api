package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlin.test.Test

internal class ApiTicketingVoucherResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiTicketingVoucherResponse(
                id = "1",
                state = ApiTicketingVoucherResponse.State.UNSUPPORTED,
                price = ApiMoney(
                    amount = 1,
                    currency = "EUR",
                ),
                product = ApiTicketingProductResponse(
                    id = "",
                    type = "",
                    createdAt = null,
                    updatedAt = Instant.parse("2021-09-10T10:00:00Z"),
                    providerId = "",
                    ticketingVendorId = "",
                    slug = "",
                    name = "",
                    description = "",
                    purchasable = false,
                    purchasableFrom = null,
                    purchasableUntil = null,
                    priceType = ApiTicketingProductResponse.PriceType.UNSUPPORTED,
                    price = ApiMoney(
                        amount = 0,
                        currency = "",
                    ),
                    purchaseOptions = emptyList(),
                    redemptionOptions = emptyList(),
                ),
                ticket = ApiTicketingVoucherResponse.Ticket(
                    id = "",
                    webviewUrl = null,
                    validityInformation = "",
                    validFrom = null,
                    validUntil = null,
                    vendorTicketDetails = ApiTicketingVoucherResponse.Ticket.VendorTicketDetails(
                        customerCode = "",
                        fullName = "",
                        host = "",
                        issuer = "",
                        purchaseId = "",
                    ),
                ),
                renewalInformation = ApiTicketingVoucherResponse.RenewalInformation(
                    renewable = false,
                    validFrom = null,
                    validUntil = null,
                ),
                rideId = "r_123",
                scheduledProcessingTime = Instant.parse("2021-09-10T10:00:00Z"),
            ),
            ticketingVoucherResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiTicketingVoucherResponse(
                id = "1",
                state = ApiTicketingVoucherResponse.State.INITIATED,
                price = ApiMoney(
                    amount = 1,
                    currency = "EUR",
                ),
                product = null,
                ticket = null,
                renewalInformation = ApiTicketingVoucherResponse.RenewalInformation(
                    renewable = false,
                    validFrom = null,
                    validUntil = null,
                ),
                rideId = null,
                scheduledProcessingTime = null,
            ),
            ticketingVoucherResponseMinimal,
        )
    }
}

private val ticketingVoucherResponse = """
{
    "id": "1",
    "state": "unsupported",
    "price": {
        "amount": 1,
        "currency": "EUR"
    },
    "ride_id": "r_123",
    "scheduled_processing_time": "2021-09-10T10:00:00Z",
    "product": {
        "id": "",
        "type": "",
        "created_at": null,
        "updated_at": "2021-09-10T10:00:00Z",
        "provider_id": "",
        "ticketing_vendor_id": "",
        "slug": "",
        "name": "",
        "description": "",
        "purchasable": false,
        "purchasable_from": null,
        "purchasable_until": null,
        "price_type": "unsupported",
        "price": {
            "amount": 0,
            "currency": ""
        },
        "purchase_options": [],
        "redemption_options": []
    },
    "ticket": {
        "id": "",
        "webview_url": null,
        "validity_information": "",
        "valid_from": null,
        "valid_until": null,
        "vendor_ticket_details": {
            "customer_code": "",
            "full_name": "",
            "host": "",
            "issuer": "",
            "purchase_id": ""
        }
    },
    "renewal_information": {
        "renewable": false,
        "valid_from": null,
        "valid_until": null
    }
}
""".trimIndent()

private val ticketingVoucherResponseMinimal = """
{
    "id": "1",
    "state": "initiated",
    "price": {
        "amount": 1,
        "currency": "EUR"
    },
    "renewal_information": {
        "renewable": false,
        "valid_from": null,
        "valid_until": null
    }
}
""".trimIndent()
