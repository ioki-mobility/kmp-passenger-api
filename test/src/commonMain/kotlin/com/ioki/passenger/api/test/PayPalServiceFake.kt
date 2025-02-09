package com.ioki.passenger.api.test

import com.ioki.passenger.api.PayPalService
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiPaypalClientTokenResponse
import com.ioki.passenger.api.result.ApiResult

public open class PayPalServiceFake : PayPalService {
    override suspend fun createPaymentMethodForPaypal(
        braintreeNonce: String,
        paypalSecureElement: String,
    ): ApiResult<ApiPaymentMethodResponse> = error("Not overridden")

    override suspend fun createPaypalClientToken(): ApiResult<ApiPaypalClientTokenResponse> = error(
        "Not overridden",
    )
}
