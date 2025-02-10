package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.AnyValue
import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest

public fun createApiPurchaseTicketingProductRequest(
    rideId: String? = null,
    purchaseOptions: List<ApiPurchaseTicketingProductRequest.Option> = emptyList(),
    redemptionOptions: List<ApiPurchaseTicketingProductRequest.Option> = emptyList(),
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
): ApiPurchaseTicketingProductRequest = ApiPurchaseTicketingProductRequest(
    rideId = rideId,
    purchaseOptions = purchaseOptions,
    redemptionOptions = redemptionOptions,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
)

public fun createApiPurchaseTicketingProductRequestOption(
    slug: String = "",
    value: AnyValue = AnyValue.IntValue(0),
): ApiPurchaseTicketingProductRequest.Option = ApiPurchaseTicketingProductRequest.Option(
    slug = slug,
    value = value,
)
