package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiUpdateClaimRequest

public fun createApiUpdateClaimRequest(
    claim: String = "",
    claimType: ApiUpdateClaimRequest.ClaimType = ApiUpdateClaimRequest.ClaimType.PHONE_NUMBER,
    code: String = "",
): ApiUpdateClaimRequest = ApiUpdateClaimRequest(
    claim = claim,
    claimType = claimType,
    code = code,
)
