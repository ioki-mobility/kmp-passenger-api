package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiVerificationResponse

public fun createApiVerificationResponse(
    phoneNumber: String = "",
    captcha: ApiVerificationResponse.Captcha? = null,
    clientChallenge: ApiVerificationResponse.ClientChallenge? = null,
): ApiVerificationResponse = ApiVerificationResponse(
    phoneNumber = phoneNumber,
    captcha = captcha,
    clientChallenge = clientChallenge,
)

public fun createApiVerificationResponseCaptcha(
    id: String = "",
    imageUrl: String? = null,
    questionPrompt: String? = null,
): ApiVerificationResponse.Captcha = ApiVerificationResponse.Captcha(
    id = id,
    imageUrl = imageUrl,
    questionPrompt = questionPrompt,
)

public fun createApiVerificationResponseClientChallenge(
    id: String = "",
    challenge: String = "",
): ApiVerificationResponse.ClientChallenge = ApiVerificationResponse.ClientChallenge(
    id = id,
    challenge = challenge,
)
