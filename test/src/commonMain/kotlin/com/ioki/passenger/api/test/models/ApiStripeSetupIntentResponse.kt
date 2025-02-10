package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiStripeSetupIntentResponse

public fun createApiStripeSetupIntentResponse(clientSecret: String = ""): ApiStripeSetupIntentResponse =
    ApiStripeSetupIntentResponse(clientSecret = clientSecret)
