package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiPaymentMethodType

public fun createApiPaymentMethodRequest(
    paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    id: String? = null,
    summary: ApiPaymentMethodRequest.Summary? = null,
): ApiPaymentMethodRequest = ApiPaymentMethodRequest(
    paymentMethodType = paymentMethodType,
    id = id,
    summary = summary,
)

public fun createApiPaymentMethodRequestSummary(
    kind: ApiPaymentMethodRequest.Summary.Kind = ApiPaymentMethodRequest.Summary.Kind.UNSUPPORTED,
    title: String = "",
    expiration: String? = null,
    mandateUrl: String? = null,
): ApiPaymentMethodRequest.Summary = ApiPaymentMethodRequest.Summary(
    kind = kind,
    title = title,
    expiration = expiration,
    mandateUrl = mandateUrl,
)
