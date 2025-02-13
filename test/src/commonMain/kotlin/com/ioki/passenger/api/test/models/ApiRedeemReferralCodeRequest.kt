package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRedeemReferralCodeRequest

public fun createApiRedeemReferralCodeRequest(code: String = ""): ApiRedeemReferralCodeRequest =
    ApiRedeemReferralCodeRequest(code = code)
