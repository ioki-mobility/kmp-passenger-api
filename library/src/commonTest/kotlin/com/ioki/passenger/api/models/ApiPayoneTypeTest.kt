package com.ioki.passenger.api.models

import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class ApiPayoneTypeTest {
    internal class ApiPayoneTypeTestExtra {
        @Test
        fun allCasesAreTested() {
            ApiPayoneType.entries.size shouldBe ApiPayoneTypeSerializationTest.data().size
        }
    }

    internal class ApiPayoneTypeSerializationTest : IokiApiModelTest() {
        @Test
        fun testPayoneTypeSerialization() {
            data().forEach {
                val type = it[0] as ApiPayoneType
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(type, json)
            }
        }

        @Test
        fun unknownValueIsDeserializedAsUnsupported() {
            testJsonStringCanBeConvertedToModel(ApiPayoneType.UNSUPPORTED, "\"something_else\"")
        }

        companion object {
            fun data(): Collection<Array<Any>> = listOf(
                arrayOf(ApiPayoneType.CARD, "\"card\""),
                arrayOf(ApiPayoneType.UNSUPPORTED, "\"unsupported\""),
            )
        }
    }
}
