package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiMatchingState(
    val id: String,
    val logs: List<MatchingStateLog>,
    val finalSummary: String?,
) {
    @Serializable
    public data class MatchingStateLog(val message: String)
}
