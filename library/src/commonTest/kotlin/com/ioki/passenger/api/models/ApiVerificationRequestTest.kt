package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiVerificationRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiVerificationRequest(
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
