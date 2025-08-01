package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiAnnouncement(
    val id: String,
    val title: String,
    val text: String,
    @SerialName(value = "starts_at")
    val startsAt: Instant,
    @SerialName(value = "ends_at")
    val endsAt: Instant,
    val severity: Severity = Severity.UNSUPPORTED,
    @SerialName(value = "created_at")
    val createdAt: Instant,
    @SerialName(value = "updated_at")
    val updatedAt: Instant,
    @SerialName(value = "show_on_every_app_start")
    val showOnEveryAppStart: Boolean,
    @SerialName(value = "additional_information_url")
    val additionalInformationUrl: String?,
) {
    @Serializable
    public enum class Severity {
        @SerialName(value = "info")
        INFO,

        @SerialName(value = "warning")
        WARNING,

        @SerialName(value = "danger")
        DANGER,
        UNSUPPORTED,
    }
}
