package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.time.Instant

internal class ApiNotificationResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiNotificationResponse(
                id = "notificationId",
                body = "This is the body of the notification.",
                notificationType = ApiNotificationResponse.NotificationType.PASSENGER_BOOKED,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                updatedAt = Instant.parse("2023-07-19T13:18:42Z"),
                deliveredAt = Instant.parse("2023-07-19T13:19:42Z"),
                channels = listOf("push"),
            ),
            notificationResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiNotificationResponse(
                id = "notificationId",
                body = "This is the body of the notification.",
                notificationType = ApiNotificationResponse.NotificationType.PICKUP_TIME_CHANGED,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                updatedAt = null,
                deliveredAt = null,
                channels = emptyList(),
            ),
            notificationResponseMinimal,
        )
    }
}

private val notificationResponse =
    """
{
    "id": "notificationId",
    "created_at": "2023-07-19T13:17:42Z",
    "updated_at": "2023-07-19T13:18:42Z",
    "delivered_at": "2023-07-19T13:19:42Z",
    "notification_type": "passenger_booked",
    "body": "This is the body of the notification.",
    "channels": ["push"]
}
"""

private val notificationResponseMinimal =
    """
{
    "id": "notificationId",
    "created_at": "2023-07-19T13:17:42Z",
    "notification_type": "pickup_time_changed",
    "body": "This is the body of the notification.",
    "channels": []
}
"""
