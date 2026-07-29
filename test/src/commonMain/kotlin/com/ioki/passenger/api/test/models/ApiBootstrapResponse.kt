package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBootstrapResponse
import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.models.ApiProduct
import com.ioki.passenger.api.models.ApiProvider
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse

public fun createApiBootstrapResponse(
    provider: ApiProvider = createApiProvider(),
    products: List<ApiProduct> = emptyList(),
    client: ApiClientInfoResponse = createApiClientInfoResponse(),
    ridesWithFailedPayments: List<ApiRideResponse> = emptyList(),
    renewableTicketingVouchers: List<ApiTicketingVoucherResponse> = emptyList(),
    productSupportUris: List<ApiBootstrapResponse.ProductSupportUri> = emptyList(),
): ApiBootstrapResponse = ApiBootstrapResponse(
    provider = provider,
    products = products,
    client = client,
    ridesWithFailedPayments = ridesWithFailedPayments,
    renewableTicketingVouchers = renewableTicketingVouchers,
    productSupportUris = productSupportUris,
)
