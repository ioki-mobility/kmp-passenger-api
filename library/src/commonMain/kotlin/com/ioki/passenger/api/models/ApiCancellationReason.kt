package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
