package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiPersonalDiscountPurchaseRequest

public fun createApiPersonalDiscountPurchaseRequest(
    personalDiscountTypeId: String = "",
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
    validFromDate: String? = null,
): ApiPersonalDiscountPurchaseRequest = ApiPersonalDiscountPurchaseRequest(
    personalDiscountTypeId = personalDiscountTypeId,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
    validFromDate = validFromDate,
)
