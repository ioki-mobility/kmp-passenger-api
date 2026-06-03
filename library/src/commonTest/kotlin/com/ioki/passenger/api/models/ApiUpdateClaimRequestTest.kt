package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUpdateClaimRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiUpdateClaimRequest(
                claim = "+491601234567",
                claimType = ApiUpdateClaimRequest.ClaimType.PHONE_NUMBER,
                code = "123456",
            ),
            updateClaimRequest,
        )
    }
}

private val updateClaimRequest =
    """
{
  "claim": "+491601234567",
  "claim_type": "phone_number",
  "code": "123456"
}
"""
