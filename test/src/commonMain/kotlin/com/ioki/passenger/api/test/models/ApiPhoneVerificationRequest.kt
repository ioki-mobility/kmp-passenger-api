package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPhoneVerificationRequest

public fun createApiPhoneVerificationRequest(
    phoneNumber: String = "",
    usDataTransferAccepted: Boolean? = null,
): ApiPhoneVerificationRequest = ApiPhoneVerificationRequest(
    phoneNumber = phoneNumber,
    usDataTransferAccepted = usDataTransferAccepted,
)
