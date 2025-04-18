package com.ioki.passenger.api.models

import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class ApiStripeTypeTest {
    internal class ApiStripeTypeTestExtra {
        @Test
        fun allCasesAreTested() {
            ApiStripeType.entries.size shouldBe ApiStripeTypeSerializationTest.data().size
        }
    }

    internal class ApiStripeTypeSerializationTest : IokiApiModelTest() {
        @Test
        fun testStripeTypeSerialization() {
            data().forEach {
                val type = it[0] as ApiStripeType
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(type, json)
            }
        }

        companion object {
            fun data(): Collection<Array<Any>> = listOf(
                arrayOf(ApiStripeType.CARD, "\"card\""),
                arrayOf(ApiStripeType.SEPA_DEBIT, "\"sepa_debit\""),
                arrayOf(ApiStripeType.UNSUPPORTED, "\"UNSUPPORTED\""),
            )
        }
    }
}
