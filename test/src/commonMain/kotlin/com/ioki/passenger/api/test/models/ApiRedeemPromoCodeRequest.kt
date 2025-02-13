package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest

public fun createApiRedeemPromoCodeRequest(code: String = ""): ApiRedeemPromoCodeRequest = ApiRedeemPromoCodeRequest(
    code = code,
)
