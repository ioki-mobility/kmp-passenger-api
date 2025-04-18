package com.ioki.passenger.api.models

import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class ApiNotificationChannelTypeTest {
    internal class ApiNotificationChannelTypeTestExtra {
        @Test
        fun allCasesAreTested() {
            ApiNotificationChannelType.entries.size shouldBe ApiNotificationChannelTypeSerializationTest.data().size
        }
    }

    internal class ApiNotificationChannelTypeSerializationTest : IokiApiModelTest() {
        @Test
        fun testNotificationChannelTypeSerialization() {
            data().forEach {
                val type = it[0] as ApiNotificationChannelType
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(type, json)
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
