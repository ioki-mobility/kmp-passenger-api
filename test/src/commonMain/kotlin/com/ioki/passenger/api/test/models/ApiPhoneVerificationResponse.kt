package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPhoneVerificationResponse

public fun createApiPhoneVerificationResponse(
    phoneNumber: String = "",
    captcha: ApiPhoneVerificationResponse.Captcha? = null,
    clientChallenge: ApiPhoneVerificationResponse.ClientChallenge? = null,
): ApiPhoneVerificationResponse = ApiPhoneVerificationResponse(
    phoneNumber = phoneNumber,
    captcha = captcha,
    clientChallenge = clientChallenge,
)

public fun createApiPhoneVerificationResponseCaptcha(
    id: String = "",
    imageUrl: String? = null,
    questionPrompt: String? = null,
): ApiPhoneVerificationResponse.Captcha = ApiPhoneVerificationResponse.Captcha(
    id = id,
    imageUrl = imageUrl,
    questionPrompt = questionPrompt,
)

public fun createApiPhoneVerificationResponseClientChallenge(
    id: String = "",
    challenge: String = "",
): ApiPhoneVerificationResponse.ClientChallenge = ApiPhoneVerificationResponse.ClientChallenge(
    id = id,
    challenge = challenge,
)
