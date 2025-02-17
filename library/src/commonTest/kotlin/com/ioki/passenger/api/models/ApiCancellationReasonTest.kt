package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.test.expect

internal class ApiCancellationReasonTest {
    internal class ApiCancellationReasonTestExtra {
        @Test
        fun allCasesAreTested() {
            expect(ApiCancellationReason.entries.size) {
                ApiCancellationReasonSerializationTest.data().size
            }
        }
    }

    internal class ApiCancellationReasonSerializationTest : IokiApiModelTest() {
        @Test
        fun testPaymentMethodTypeSerialization() {
            data().forEach {
                val reason = it[0] as ApiCancellationReason
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(reason, json)
            }
        }

        companion object {
            fun data(): Collection<Array<Any>> {
                return listOf(
                    arrayOf(
                        ApiCancellationReason.DRIVER_CANCELLED,
                        "\"driver_cancelled\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.DRIVER_DID_NOT_ACCEPT_IN_TIME,
                        "\"driver_did_not_accept_in_time\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.DRIVER_REJECTED,
                        "\"driver_rejected\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.NO_STATIONS_FOUND,
                        "\"no_stations_found\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.NO_VEHICLE_AVAILABLE,
                        "\"no_vehicle_available\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED,
                        "\"passenger_cancelled\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED_SEARCHING_RIDE,
                        "\"passenger_cancelled_searching_ride\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED_OFFERED_RIDE,
                        "\"passenger_cancelled_offered_ride\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED_WAITING_FOR_DRIVER,
                        "\"passenger_cancelled_waiting_for_driver\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED_AFTER_PICKUP,
                        "\"passenger_cancelled_after_pickup\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_CANCELLED_BOOKED_RIDE,
                        "\"passenger_cancelled_booked_ride\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PASSENGER_DID_NOT_ACCEPT_IN_TIME,
                        "\"passenger_did_not_accept_in_time\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.RIDE_REQUEST_OUTDATED,
                        "\"ride_request_outdated\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.TRANSACTIONAL_SAVE_FAILED,
                        "\"transactional_save_failed\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.APPLY_FAILED,
                        "\"apply_failed\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.NO_TASK_LIST_FOUND,
                        "\"no_task_list_found\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.PROHIBIT_PARALLEL_FILTER,
                        "\"prohibit_parallel_filter\"",
                    ),
                    arrayOf(
                        ApiCancellationReason.UNSUPPORTED,
                        "\"UNSUPPORTED\"",
                    ),
                )
            }
        }
    }
}
