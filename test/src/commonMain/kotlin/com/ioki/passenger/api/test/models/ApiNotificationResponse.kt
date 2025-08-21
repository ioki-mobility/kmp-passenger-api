package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiNotificationResponse
import kotlin.time.Instant

public fun createApiNotificationResponse(): ApiNotificationResponse = ApiNotificationResponse(
    id = "",
    body = "",
    createdAt = Instant.DISTANT_PAST,
    updatedAt = null,
    deliveredAt = null,
    notificationType = ApiNotificationResponse.NotificationType.UNSUPPORTED,
    channels = emptyList(),
)
