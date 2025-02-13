package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiPaymentMethodType

public fun createApiPaymentMethodResponse(
    paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    id: String? = null,
    summary: ApiPaymentMethodResponse.Summary? = null,
): ApiPaymentMethodResponse = ApiPaymentMethodResponse(
    paymentMethodType = paymentMethodType,
    id = id,
    summary = summary,
)

public fun createApiPaymentMethodResponseSummary(
    kind: ApiPaymentMethodResponse.Summary.Kind = ApiPaymentMethodResponse.Summary.Kind.UNSUPPORTED,
    title: String = "",
    expiration: String? = null,
    mandateUrl: String? = null,
): ApiPaymentMethodResponse.Summary = ApiPaymentMethodResponse.Summary(
    kind = kind,
    title = title,
    expiration = expiration,
    mandateUrl = mandateUrl,
)
