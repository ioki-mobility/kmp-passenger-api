package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiPaymentMethodType

public fun createApiPaymentMethodRequest(
    paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    id: String? = null,
): ApiPaymentMethodRequest = ApiPaymentMethodRequest(
    paymentMethodType = paymentMethodType,
    id = id,
)
