package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest

public fun createApiPurchasingCreditPackageRequest(
    cost: Int = 0,
    value: Int = 0,
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
): ApiPurchasingCreditPackageRequest = ApiPurchasingCreditPackageRequest(
    cost = cost,
    value = value,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
)
