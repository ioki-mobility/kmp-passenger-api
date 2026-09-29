package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPaymentMethodRequest
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest

public fun createApiRenewTicketingVoucherRequest(
    paymentMethod: ApiPaymentMethodRequest = createApiPaymentMethodRequest(),
    paypalSecureElement: String? = null,
    onSession: Boolean? = null,
    async: Boolean? = null,
): ApiRenewTicketingVoucherRequest = ApiRenewTicketingVoucherRequest(
    paymentMethod = paymentMethod,
    paypalSecureElement = paypalSecureElement,
    onSession = onSession,
    async = async,
)
