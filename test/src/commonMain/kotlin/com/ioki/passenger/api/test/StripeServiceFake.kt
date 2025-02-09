package com.ioki.passenger.api.test

import com.ioki.passenger.api.StripeService
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiStripeSetupIntentResponse
import com.ioki.passenger.api.result.ApiResult

public open class StripeServiceFake : StripeService {
    override suspend fun requestStripeSetupIntent(): ApiResult<ApiStripeSetupIntentResponse> = error(
        "Not overridden",
    )

    override suspend fun createPaymentMethodFromStripePaymentMethod(
        stripePaymentMethodId: String,
    ): ApiResult<ApiPaymentMethodResponse> = error("Not overridden")
}
