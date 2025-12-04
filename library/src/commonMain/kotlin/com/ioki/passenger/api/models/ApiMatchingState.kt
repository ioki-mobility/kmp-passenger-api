package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiMatchingState(
    val id: String,
    val logs: List<MatchingStateLog>,
    @SerialName("final_summary")
    val finalSummary: String?,
) {
    @Serializable
    public data class MatchingStateLog(val message: String)
}
