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
    wallet: ApiPaymentMethodResponse.Summary.Wallet? = null,
    brand: ApiPaymentMethodResponse.Summary.Brand? = null,
    title: String = "",
    last4: String? = null,
    expiration: String? = null,
    mandateUrl: String? = null,
): ApiPaymentMethodResponse.Summary = ApiPaymentMethodResponse.Summary(
    kind = kind,
    wallet = wallet,
    title = title,
    brand = brand,
    last4 = last4,
    expiration = expiration,
    mandateUrl = mandateUrl,
)
