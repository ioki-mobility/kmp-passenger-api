package com.ioki.passenger.api.test

import com.ioki.passenger.api.RedeemService
import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest
import com.ioki.passenger.api.models.ApiRedeemedPromoCodeResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeRedeemService : RedeemService {
    override suspend fun redeemPromoCode(request: ApiRedeemPromoCodeRequest): ApiResult<ApiRedeemedPromoCodeResponse> =
        error("Not overridden")

    override suspend fun redeemReferralCode(code: String): ApiResult<Unit> = error("Not overridden")
}
