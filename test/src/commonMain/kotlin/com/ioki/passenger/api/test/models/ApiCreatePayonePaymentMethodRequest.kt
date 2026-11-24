package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCreatePayonePaymentMethodRequest
import com.ioki.passenger.api.models.ApiPayoneType

public fun createApiCreatePayonePaymentMethodRequest(
    type: ApiPayoneType = ApiPayoneType.UNSUPPORTED,
): ApiCreatePayonePaymentMethodRequest = ApiCreatePayonePaymentMethodRequest(
    type = type,
)
