package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiResettleDebitsRequest

public fun createApiResettleDebitsRequest(
    purchaseIds: List<String> = emptyList(),
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
    amount: Int = 0,
): ApiResettleDebitsRequest = ApiResettleDebitsRequest(
    purchaseIds = purchaseIds,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
    amount = amount,
)
