package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodCreationRequest

public fun createApiPaymentMethodCreationRequest(
    paymentMethodType: String = "",
    details: ApiPaymentMethodCreationRequest.Details = createApiPaymentMethodCreationRequestDetails(),
): ApiPaymentMethodCreationRequest = ApiPaymentMethodCreationRequest(
    paymentMethodType = paymentMethodType,
    details = details,
)

public fun createApiPaymentMethodCreationRequestDetails(
    stripePaymentMethodId: String? = null,
    braintreeNonce: String? = null,
    paypalSecureElement: String? = null,
): ApiPaymentMethodCreationRequest.Details = ApiPaymentMethodCreationRequest.Details(
    stripePaymentMethodId = stripePaymentMethodId,
    braintreeNonce = braintreeNonce,
    paypalSecureElement = paypalSecureElement,
)
