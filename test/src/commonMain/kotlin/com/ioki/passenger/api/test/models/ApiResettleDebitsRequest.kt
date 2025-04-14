package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiResettleDebitsRequest
import com.ioki.passenger.api.models.PurchasePaymentMethod

public fun createApiResettleDebitsRequest(
    purchaseIds: List<String> = emptyList(),
    paymentMethod: PurchasePaymentMethod = createPaymentMethod(),
    paypalSecureElement: String? = null,
    amount: Int = 0,
): ApiResettleDebitsRequest = ApiResettleDebitsRequest(
    purchaseIds = purchaseIds,
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
    amount = amount,
)
