package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCreateLogPayPaymentMethodRequest
import com.ioki.passenger.api.models.ApiLogPayType

public fun createApiCreateLogPayPaymentMethodRequest(
    type: ApiLogPayType = ApiLogPayType.UNSUPPORTED,
): ApiCreateLogPayPaymentMethodRequest = ApiCreateLogPayPaymentMethodRequest(
    type = type,
)
