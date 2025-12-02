package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMatchingState

public fun createApiMatchingState(
    id: String = "matching-state-id",
    logs: List<ApiMatchingState.MatchingStateLog> = emptyList(),
    finalSummary: String? = null,
): ApiMatchingState = ApiMatchingState(
    id = id,
    logs = logs,
    finalSummary = finalSummary,
)
