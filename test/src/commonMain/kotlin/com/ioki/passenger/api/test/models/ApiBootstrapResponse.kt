package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBootstrapResponse
import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiProduct
import com.ioki.passenger.api.models.ApiProvider
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiStripeType
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import com.ioki.passenger.api.models.PaymentServiceProvider

public fun createApiBootstrapResponse(
    provider: ApiProvider = createApiProvider(),
    products: List<ApiProduct> = emptyList(),
    client: ApiClientInfoResponse = createApiClientInfoResponse(),
    paymentServiceProvider: PaymentServiceProvider? = null,
    ridesWithFailedPayments: List<ApiRideResponse> = emptyList(),
    renewableTicketingVouchers: List<ApiTicketingVoucherResponse> = emptyList(),
    productSupportUris: List<ApiBootstrapResponse.ProductSupportUri> = emptyList(),
): ApiBootstrapResponse = ApiBootstrapResponse(
    provider = provider,
    products = products,
    client = client,
    paymentServiceProvider = paymentServiceProvider,
    ridesWithFailedPayments = ridesWithFailedPayments,
    renewableTicketingVouchers = renewableTicketingVouchers,
    productSupportUris = productSupportUris,
)

public fun createStripePaymentServiceProvider(
    stripeAccountId: String? = null,
    stripeTypes: List<ApiStripeType>? = null,
    googlePaySupported: Boolean = false,
): PaymentServiceProvider = PaymentServiceProvider.Stripe(
    googlePaySupported = googlePaySupported,
    stripeTypes = stripeTypes,
    stripeAccountId = stripeAccountId,
)

public fun createLogPayPaymentServiceProvider(logPayTypes: List<ApiLogPayType>? = null): PaymentServiceProvider =
    PaymentServiceProvider.LogPay(logPayTypes = logPayTypes)
