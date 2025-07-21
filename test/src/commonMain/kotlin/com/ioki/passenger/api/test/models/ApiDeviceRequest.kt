package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiDeviceRequest

public fun createApiDeviceRequest(
    token: String = "",
    supportsEncryptedNotifications: Boolean = true,
): ApiDeviceRequest = ApiDeviceRequest(
    token = token,
    supportsEncryptedNotifications = supportsEncryptedNotifications,
)
