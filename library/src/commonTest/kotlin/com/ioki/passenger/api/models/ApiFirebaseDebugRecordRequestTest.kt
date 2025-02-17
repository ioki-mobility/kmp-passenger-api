package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiFirebaseDebugRecordRequestTest : IokiApiModelTest() {
    @Test
    fun serialization_RidePayload() {
        testJsonStringCanBeConvertedToModel(
            ApiFirebaseDebugRecordRequest(
                path = "user/<user_id>/rides/<ride_id>",
                payload = ApiFirebaseDebugRecordRequest.Payload.RidePayload(
                    updatedAt = "2022-01-05T08:35:58Z",
                    randomizedValue = "a4a54f83f1e55808c5d85ddfa17ce9d6",
                    debugId = "fdr_792c0e71-a843-4a0e-b0dc-83823657dc7f",
                ),
            ),
            firebaseDebugRecordRide,
        )
    }

    @Test
    fun serialization_VehiclePayload() {
        testJsonStringCanBeConvertedToModel(
            ApiFirebaseDebugRecordRequest(
                path = "user/<user_id>/rides/<ride_id>",
                payload = ApiFirebaseDebugRecordRequest.Payload.VehiclePositionPayload(
                    encrypted = "encrypted",
                    iv = "iv",
                    tag = "tag",
                    debugId = "fdr_792c0e71-a843-4a0e-b0dc-83823657dc7f",
                ),
            ),
            firebaseDebugRecordVehicle,
        )
    }
}

private val firebaseDebugRecordRide =
    """
        {
          "path": "user/<user_id>/rides/<ride_id>",
          "payload": {
            "type": "RIDE_PAYLOAD_TYPE",
            "updated_at": "2022-01-05T08:35:58Z",
            "randomized_value": "a4a54f83f1e55808c5d85ddfa17ce9d6",
            "debug_id": "fdr_792c0e71-a843-4a0e-b0dc-83823657dc7f"
          }
        }
    """

private val firebaseDebugRecordVehicle =
    """
        {
          "path": "user/<user_id>/rides/<ride_id>",
          "payload": {
            "type": "VEHICLE_POSITION_PAYLOAD_TYPE",
            "encrypted_gcm": "encrypted",
            "iv_gcm": "iv",
            "tag_gcm": "tag",
            "debug_id": "fdr_792c0e71-a843-4a0e-b0dc-83823657dc7f"
          }
        }
    """
