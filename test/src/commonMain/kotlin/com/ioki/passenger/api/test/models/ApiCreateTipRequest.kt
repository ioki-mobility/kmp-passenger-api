package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCreateTipRequest
import com.ioki.passenger.api.models.ApiPaymentMethodRequest

public fun createApiCreateTipRequest(
    amount: Int = 0,
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
    onSession: Boolean? = null,
    async: Boolean? = null,
): ApiCreateTipRequest = ApiCreateTipRequest(
    amount = amount,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
    onSession = onSession,
    async = async,
)
