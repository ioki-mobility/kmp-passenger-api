package com.ioki.passenger.api.test

import com.ioki.passenger.api.VerificationService
import com.ioki.passenger.api.models.ApiCaptchaRequest
import com.ioki.passenger.api.models.ApiClientChallengeRequest
import com.ioki.passenger.api.models.ApiVerificationRequest
import com.ioki.passenger.api.models.ApiVerificationResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeVerificationService : VerificationService {
    override suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun requestVerification(
        verification: ApiVerificationRequest,
    ): ApiResult<ApiVerificationResponse> = error("Not overridden")
}
