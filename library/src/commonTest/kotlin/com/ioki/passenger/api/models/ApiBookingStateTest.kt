package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.test.expect

internal class ApiBookingStateTest {
    internal class ApiBookingStateTestExtra {
        @Test
        fun allCasesAreTested() {
            expect(ApiBookingState.entries.size) { ApiBookingStateSerializationTest.data().size }
        }
    }

    internal class ApiBookingStateSerializationTest : IokiApiModelTest() {
        @Test
        fun testBookingStateSerialization() {
            data().forEach {
                val bookingState = it[0] as ApiBookingState
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(bookingState, json)
            }
        }

        companion object {
            fun data(): Collection<Array<Any>> {
                return listOf(
                    arrayOf(ApiBookingState.CANCELLED, "\"cancelled\""),
                    arrayOf(ApiBookingState.DRIVER_ACCEPTED, "\"driver_accepted\""),
                    arrayOf(ApiBookingState.PASSENGER_ACCEPTED, "\"passenger_accepted\""),
                    arrayOf(ApiBookingState.DROPPED_OFF, "\"dropped_off\""),
                    arrayOf(ApiBookingState.NOT_STARTED, "\"not_started\""),
                    arrayOf(ApiBookingState.PICKED_UP, "\"picked_up\""),
                    arrayOf(ApiBookingState.READY, "\"ready\""),
                    arrayOf(ApiBookingState.SEARCHING, "\"searching\""),
                    arrayOf(ApiBookingState.UNSUPPORTED, "\"UNSUPPORTED\""),
                )
            }
        }
    }
}
