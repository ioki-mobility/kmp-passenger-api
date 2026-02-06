package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodCreationRequest

public fun createApiPaymentMethodCreationRequest(
    paymentMethodType: String = "",
    attached: Boolean = false,
    details: ApiPaymentMethodCreationRequest.Details = createApiPaymentMethodCreationRequestDetails(),
): ApiPaymentMethodCreationRequest = ApiPaymentMethodCreationRequest(
    paymentMethodType = paymentMethodType,
    attached = attached,
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
