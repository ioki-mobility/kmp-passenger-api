package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.test.expect

internal class ApiNotificationChannelTypeTest {
    internal class ApiNotificationChannelTypeTestExtra {
        @Test
        fun allCasesAreTested() {
            expect(ApiNotificationChannelType.entries.size) { ApiNotificationChannelTypeSerializationTest.data().size }
        }
    }

    internal class ApiNotificationChannelTypeSerializationTest : IokiApiModelTest() {
        @Test
        fun testNotificationChannelTypeSerialization() {
            data().forEach {
                val type = it[0] as ApiNotificationChannelType
                val json = it[1] as String
                testSerializationWithJsonString(type, json)
            }
        }

        companion object {
            fun data(): Collection<Array<Any>> {
                return listOf(
                    arrayOf(ApiNotificationChannelType.SMS, "\"sms\""),
                    arrayOf(ApiNotificationChannelType.EMAIL, "\"email\""),
                    arrayOf(ApiNotificationChannelType.UNSUPPORTED, "\"UNSUPPORTED\""),
                )
            }
        }
    }
}
