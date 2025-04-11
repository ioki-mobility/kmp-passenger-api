package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodType
import com.ioki.passenger.api.models.ApiSettleDebitRequest
import com.ioki.passenger.api.models.PurchasePaymentMethod

public fun createApiSettleDebitRequest(
    paymentMethod: PurchasePaymentMethod = createPaymentMethod(),
    paypalSecureElement: String? = null,
): ApiSettleDebitRequest = ApiSettleDebitRequest(
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
)

public fun createPaymentMethod(
    paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    id: String = "",
): PurchasePaymentMethod = PurchasePaymentMethod(paymentMethodType = paymentMethodType, id = id)
