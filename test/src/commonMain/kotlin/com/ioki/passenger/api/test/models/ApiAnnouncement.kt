package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAnnouncement
import kotlin.time.Instant

public fun createApiAnnouncement(
    id: String = "",
    title: String = "",
    text: String = "",
    startsAt: Instant = Instant.DISTANT_PAST,
    endsAt: Instant = Instant.DISTANT_PAST,
    severity: ApiAnnouncement.Severity = ApiAnnouncement.Severity.UNSUPPORTED,
    createdAt: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant = Instant.DISTANT_PAST,
    showOnEveryAppStart: Boolean = false,
    additionalInformationUrl: String? = null,
): ApiAnnouncement = ApiAnnouncement(
    id = id,
    title = title,
    text = text,
    startsAt = startsAt,
    endsAt = endsAt,
    severity = severity,
    createdAt = createdAt,
    updatedAt = updatedAt,
    showOnEveryAppStart = showOnEveryAppStart,
    additionalInformationUrl = additionalInformationUrl,
)
