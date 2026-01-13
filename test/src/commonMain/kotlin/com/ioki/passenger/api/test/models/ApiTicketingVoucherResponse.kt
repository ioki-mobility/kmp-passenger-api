package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import kotlin.time.Instant

public fun createApiTicketingVoucherResponse(
    id: String = "",
    state: ApiTicketingVoucherResponse.State = ApiTicketingVoucherResponse.State.UNSUPPORTED,
    price: ApiMoney = createApiMoney(),
    product: ApiTicketingProductResponse? = null,
    ticket: ApiTicketingVoucherResponse.Ticket? = null,
    rideId: String? = null,
    renewalInformation: ApiTicketingVoucherResponse.RenewalInformation = createApiTicketingVoucherRenewalInformation(),
): ApiTicketingVoucherResponse = ApiTicketingVoucherResponse(
    id = id,
    state = state,
    price = price,
    product = product,
    ticket = ticket,
    rideId = rideId,
    renewalInformation = renewalInformation,
)

public fun createApiTicketingVoucherTicket(
    id: String = "",
    webviewUrl: String? = null,
    validityInformation: String = "",
    validFrom: Instant? = null,
    validUntil: Instant? = null,
    vendorTicketDetails: ApiTicketingVoucherResponse.Ticket.VendorTicketDetails? = null,
): ApiTicketingVoucherResponse.Ticket = ApiTicketingVoucherResponse.Ticket(
    id = id,
    webviewUrl = webviewUrl,
    validityInformation = validityInformation,
    validFrom = validFrom,
    validUntil = validUntil,
    vendorTicketDetails = vendorTicketDetails,
)

public fun createApiTicketingVoucherTicketVendorTicketDetails(
    customerCode: String = "",
    fullName: String = "",
    host: String = "",
    issuer: String = "",
    purchaseId: String = "",
): ApiTicketingVoucherResponse.Ticket.VendorTicketDetails = ApiTicketingVoucherResponse.Ticket.VendorTicketDetails(
    customerCode = customerCode,
    fullName = fullName,
    host = host,
    issuer = issuer,
    purchaseId = purchaseId,
)

public fun createApiTicketingVoucherRenewalInformation(
    renewable: Boolean = false,
    validFrom: Instant? = null,
    validUntil: Instant? = null,
): ApiTicketingVoucherResponse.RenewalInformation = ApiTicketingVoucherResponse.RenewalInformation(
    renewable = renewable,
    validFrom = validFrom,
    validUntil = validUntil,
)
