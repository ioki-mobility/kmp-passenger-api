package com.ioki.passenger.api.test

import com.ioki.passenger.api.PhoneVerificationService
import com.ioki.passenger.api.models.ApiCaptchaRequest
import com.ioki.passenger.api.models.ApiClientChallengeRequest
import com.ioki.passenger.api.models.ApiPhoneVerificationRequest
import com.ioki.passenger.api.models.ApiPhoneVerificationResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakePhoneVerificationService : PhoneVerificationService {
    override suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun requestPhoneVerification(
        verification: ApiPhoneVerificationRequest,
    ): ApiResult<ApiPhoneVerificationResponse> = error("Not overridden")
}
