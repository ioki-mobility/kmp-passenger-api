package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPhoneVerificationRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPhoneVerificationRequest(
                claim = "+491601234567",
                channel = ApiVerificationChannelType.SMS,
                usDataTransferAccepted = null,
            ),
            verification,
        )
    }
}

private val verification =
    """
{
  "claim": "+491601234567",
  "channel": "sms"
}
"""
