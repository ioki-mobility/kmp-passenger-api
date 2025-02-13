package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import kotlinx.datetime.Instant

public fun createApiTicketingVoucherResponse(
    id: String = "",
    state: ApiTicketingVoucherResponse.State = ApiTicketingVoucherResponse.State.UNSUPPORTED,
    price: ApiMoney = createApiMoney(),
    product: ApiTicketingProductResponse? = null,
    ticket: ApiTicketingVoucherResponse.Ticket? = null,
    renewalInformation: ApiTicketingVoucherResponse.RenewalInformation = createApiTicketingVoucherRenewalInformation(),
): ApiTicketingVoucherResponse = ApiTicketingVoucherResponse(
    id = id,
    state = state,
    price = price,
    product = product,
    ticket = ticket,
    renewalInformation = renewalInformation,
)

public fun createApiTicketingVoucherTicket(
    id: String = "",
    webviewUrl: String? = null,
    validityInformation: String = "",
    validFrom: Instant? = null,
    validUntil: Instant? = null,
): ApiTicketingVoucherResponse.Ticket = ApiTicketingVoucherResponse.Ticket(
    id = id,
    webviewUrl = webviewUrl,
    validityInformation = validityInformation,
    validFrom = validFrom,
    validUntil = validUntil,
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
