package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiFirebaseDebugRecordRequest(
    @SerialName("path") val path: String,
    @SerialName("payload") val payload: Payload,
) {
    @Serializable
    public sealed class Payload {
        @Serializable
        @SerialName("RIDE_PAYLOAD_TYPE")
        public data class RidePayload(
            @SerialName("updated_at") val updatedAt: String,
            @SerialName("randomized_value") val randomizedValue: String,
            @SerialName("debug_id") val debugId: String,
        ) : Payload()

        @Serializable
        @SerialName("VEHICLE_POSITION_PAYLOAD_TYPE")
        public data class VehiclePositionPayload(
            @SerialName("debug_id") val debugId: String,
            @SerialName("encrypted_gcm") val encrypted: String,
            @SerialName("iv_gcm") val iv: String,
            @SerialName("tag_gcm") val tag: String,
        ) : Payload()
    }
}
