package com.ioki.passenger.api.test

import com.ioki.passenger.api.FirebaseService
import com.ioki.passenger.api.models.ApiDeviceRequest
import com.ioki.passenger.api.models.ApiDeviceResponse
import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest
import com.ioki.passenger.api.models.ApiFirebaseTokenResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeFirebaseService : FirebaseService {
    override suspend fun createDevice(deviceRequest: ApiDeviceRequest): ApiResult<ApiDeviceResponse> =
        error("Not overridden")

    override suspend fun getFirebaseToken(): ApiResult<ApiFirebaseTokenResponse> = error("Not overridden")

    override suspend fun sendFirebaseDebugRecord(
        debugId: String,
        firebaseDebugRecord: ApiFirebaseDebugRecordRequest,
    ): ApiResult<Unit> = error("Not overridden")
}
