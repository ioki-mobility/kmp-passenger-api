package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiVerificationChannelType

public fun createApiRequestTokenRequest(
    claim: String = "",
    channel: ApiVerificationChannelType = ApiVerificationChannelType.UNSUPPORTED,
    code: String = "",
): ApiRequestTokenRequest = ApiRequestTokenRequest(claim = claim, channel = channel, code = code)
