package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest

public fun createApiFirebaseDebugRecordRequest(
    path: String = "",
    payload: ApiFirebaseDebugRecordRequest.Payload = createApiFirebaseDebugRecordRequestRidePayload(),
): ApiFirebaseDebugRecordRequest = ApiFirebaseDebugRecordRequest(
    path = path,
    payload = payload,
)

public fun createApiFirebaseDebugRecordRequestRidePayload(
    updatedAt: String = "",
    randomizedValue: String = "",
    debugId: String = "",
): ApiFirebaseDebugRecordRequest.Payload.RidePayload = ApiFirebaseDebugRecordRequest.Payload.RidePayload(
    updatedAt = updatedAt,
    randomizedValue = randomizedValue,
    debugId = debugId,
)

public fun createApiFirebaseDebugRecordRequestVehiclePayload(
    debugId: String = "",
    encrypted: String = "",
    iv: String = "",
    tag: String = "",
): ApiFirebaseDebugRecordRequest.Payload.VehiclePositionPayload =
    ApiFirebaseDebugRecordRequest.Payload.VehiclePositionPayload(
        debugId = debugId,
        encrypted = encrypted,
        iv = iv,
        tag = tag,
    )
