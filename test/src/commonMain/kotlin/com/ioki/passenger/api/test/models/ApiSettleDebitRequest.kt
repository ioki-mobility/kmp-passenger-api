package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiSettleDebitRequest

public fun createApiSettleDebitRequest(
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
): ApiSettleDebitRequest = ApiSettleDebitRequest(
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
)
