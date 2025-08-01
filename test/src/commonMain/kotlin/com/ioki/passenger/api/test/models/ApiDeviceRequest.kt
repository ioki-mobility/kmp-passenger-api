package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiDeviceRequest

public fun createApiDeviceRequest(
    token: String = "",
    supportsEncryptedNotifications: Boolean = false,
): ApiDeviceRequest = ApiDeviceRequest(
    token = token,
    supportsEncryptedNotifications = supportsEncryptedNotifications,
)
