package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiVerificationRequest
import com.ioki.passenger.api.models.ApiVerificationChannelType

public fun createApiVerificationRequest(
    claim: String = "",
    channel: ApiVerificationChannelType = ApiVerificationChannelType.UNSUPPORTED,
    usDataTransferAccepted: Boolean? = null,
): ApiVerificationRequest = ApiVerificationRequest(
    claim = claim,
    channel = channel,
    usDataTransferAccepted = usDataTransferAccepted,
)
