package com.ioki.passenger.api.test

import com.ioki.passenger.api.NotificationService
import com.ioki.passenger.api.models.ApiProviderNotificationSettingsResponse
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest
import com.ioki.passenger.api.models.ApiUserNotificationSettingsResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeNotificationService : NotificationService {
    override suspend fun getUserNotificationSettings(): ApiResult<List<ApiUserNotificationSettingsResponse>?> =
        error("Not overridden")

    @Suppress("ktlint:standard:function-signature")
    override suspend fun getAvailableProviderNotificationSettings():
        ApiResult<List<ApiProviderNotificationSettingsResponse>> = error("Not overridden")

    @Suppress("ktlint:standard:function-signature")
    override suspend fun getDefaultProviderNotificationSettings():
        ApiResult<List<ApiProviderNotificationSettingsResponse>> = error("Not overridden")

    override suspend fun updateUserNotificationSettings(
        request: ApiUpdateUserNotificationSettingsRequest,
        userId: String,
    ): ApiResult<ApiUserNotificationSettingsResponse> = error("Not overridden")
}
