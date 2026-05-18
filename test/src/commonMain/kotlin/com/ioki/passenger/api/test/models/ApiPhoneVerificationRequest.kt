package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPhoneVerificationRequest
import com.ioki.passenger.api.models.ApiVerificationChannelType

public fun createApiPhoneVerificationRequest(
    claim: String = "",
    channel: ApiVerificationChannelType = ApiVerificationChannelType.UNSUPPORTED,
    usDataTransferAccepted: Boolean? = null,
): ApiPhoneVerificationRequest = ApiPhoneVerificationRequest(
    claim = claim,
    channel = channel,
    usDataTransferAccepted = usDataTransferAccepted,
)
