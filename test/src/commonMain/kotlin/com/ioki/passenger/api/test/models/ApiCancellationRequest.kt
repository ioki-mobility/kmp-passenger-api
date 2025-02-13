package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCancellationRequest

public fun createApiCancellationRequest(
    rideVersion: Int = 0,
    code: String? = null,
    cancellationStatementId: String? = null,
): ApiCancellationRequest = ApiCancellationRequest(
    rideVersion = rideVersion,
    code = code,
    cancellationStatementId = cancellationStatementId,
)
