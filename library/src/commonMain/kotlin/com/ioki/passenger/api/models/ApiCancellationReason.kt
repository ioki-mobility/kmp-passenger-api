package com.ioki.passenger.api.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public enum class ApiCancellationReason {
    @SerialName(value = "passenger_cancelled")
    PASSENGER_CANCELLED,

    @SerialName(value = "passenger_cancelled_searching_ride")
    PASSENGER_CANCELLED_SEARCHING_RIDE,

    @SerialName(value = "passenger_cancelled_offered_ride")
    PASSENGER_CANCELLED_OFFERED_RIDE,

    @SerialName(value = "passenger_cancelled_waiting_for_driver")
    PASSENGER_CANCELLED_WAITING_FOR_DRIVER,

    @SerialName(value = "passenger_cancelled_after_pickup")
    PASSENGER_CANCELLED_AFTER_PICKUP,

    @SerialName(value = "passenger_cancelled_booked_ride")
    PASSENGER_CANCELLED_BOOKED_RIDE,

    @SerialName(value = "driver_cancelled")
    DRIVER_CANCELLED,

    @SerialName(value = "driver_rejected")
    DRIVER_REJECTED,

    @SerialName(value = "no_vehicle_available")
    NO_VEHICLE_AVAILABLE,

    @SerialName(value = "passenger_did_not_accept_in_time")
    PASSENGER_DID_NOT_ACCEPT_IN_TIME,

    @SerialName(value = "driver_did_not_accept_in_time")
    DRIVER_DID_NOT_ACCEPT_IN_TIME,

    @SerialName(value = "ride_request_outdated")
    RIDE_REQUEST_OUTDATED,

    @SerialName(value = "transactional_save_failed")
    TRANSACTIONAL_SAVE_FAILED,

    @SerialName(value = "no_stations_found")
    NO_STATIONS_FOUND,

    @SerialName(value = "apply_failed")
    APPLY_FAILED,

    @SerialName(value = "no_task_list_found")
    NO_TASK_LIST_FOUND,

    @SerialName(value = "prohibit_parallel_filter")
    PROHIBIT_PARALLEL_FILTER,

    @SerialName(value = "operator_cancelled")
    OPERATOR_CANCELLED,
    UNSUPPORTED,
}

internal object ApiCancellationReasonSerializer : KSerializer<ApiCancellationReason?> {
    override val descriptor = String.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: ApiCancellationReason?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }

        encoder.encodeString(
            when (value) {
                ApiCancellationReason.PASSENGER_CANCELLED -> "passenger_cancelled"
                ApiCancellationReason.PASSENGER_CANCELLED_SEARCHING_RIDE -> "passenger_cancelled_searching_ride"
                ApiCancellationReason.PASSENGER_CANCELLED_OFFERED_RIDE -> "passenger_cancelled_offered_ride"
                ApiCancellationReason.PASSENGER_CANCELLED_WAITING_FOR_DRIVER -> "passenger_cancelled_waiting_for_driver"
                ApiCancellationReason.PASSENGER_CANCELLED_AFTER_PICKUP -> "passenger_cancelled_after_pickup"
                ApiCancellationReason.PASSENGER_CANCELLED_BOOKED_RIDE -> "passenger_cancelled_booked_ride"
                ApiCancellationReason.DRIVER_CANCELLED -> "driver_cancelled"
                ApiCancellationReason.DRIVER_REJECTED -> "driver_rejected"
                ApiCancellationReason.NO_VEHICLE_AVAILABLE -> "no_vehicle_available"
                ApiCancellationReason.PASSENGER_DID_NOT_ACCEPT_IN_TIME -> "passenger_did_not_accept_in_time"
                ApiCancellationReason.DRIVER_DID_NOT_ACCEPT_IN_TIME -> "driver_did_not_accept_in_time"
                ApiCancellationReason.RIDE_REQUEST_OUTDATED -> "ride_request_outdated"
                ApiCancellationReason.TRANSACTIONAL_SAVE_FAILED -> "transactional_save_failed"
                ApiCancellationReason.NO_STATIONS_FOUND -> "no_stations_found"
                ApiCancellationReason.APPLY_FAILED -> "apply_failed"
                ApiCancellationReason.NO_TASK_LIST_FOUND -> "no_task_list_found"
                ApiCancellationReason.PROHIBIT_PARALLEL_FILTER -> "prohibit_parallel_filter"
                ApiCancellationReason.OPERATOR_CANCELLED -> "operator_cancelled"
                ApiCancellationReason.UNSUPPORTED -> "UNSUPPORTED"
            },
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): ApiCancellationReason? {
        val stringValue =
            decoder.decodeNullableSerializableValue(String.serializer().nullable) ?: return null

        return when (stringValue) {
            "passenger_cancelled" -> ApiCancellationReason.PASSENGER_CANCELLED
            "passenger_cancelled_searching_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_SEARCHING_RIDE
            "passenger_cancelled_offered_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_OFFERED_RIDE
            "passenger_cancelled_waiting_for_driver" -> ApiCancellationReason.PASSENGER_CANCELLED_WAITING_FOR_DRIVER
            "passenger_cancelled_after_pickup" -> ApiCancellationReason.PASSENGER_CANCELLED_AFTER_PICKUP
            "passenger_cancelled_booked_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_BOOKED_RIDE
            "driver_cancelled" -> ApiCancellationReason.DRIVER_CANCELLED
            "driver_rejected" -> ApiCancellationReason.DRIVER_REJECTED
            "no_vehicle_available" -> ApiCancellationReason.NO_VEHICLE_AVAILABLE
            "passenger_did_not_accept_in_time" -> ApiCancellationReason.PASSENGER_DID_NOT_ACCEPT_IN_TIME
            "driver_did_not_accept_in_time" -> ApiCancellationReason.DRIVER_DID_NOT_ACCEPT_IN_TIME
            "ride_request_outdated" -> ApiCancellationReason.RIDE_REQUEST_OUTDATED
            "transactional_save_failed" -> ApiCancellationReason.TRANSACTIONAL_SAVE_FAILED
            "no_stations_found" -> ApiCancellationReason.NO_STATIONS_FOUND
            "apply_failed" -> ApiCancellationReason.APPLY_FAILED
            "no_task_list_found" -> ApiCancellationReason.NO_TASK_LIST_FOUND
            "prohibit_parallel_filter" -> ApiCancellationReason.PROHIBIT_PARALLEL_FILTER
            "operator_cancelled" -> ApiCancellationReason.OPERATOR_CANCELLED
            else -> ApiCancellationReason.UNSUPPORTED
        }
    }
}
