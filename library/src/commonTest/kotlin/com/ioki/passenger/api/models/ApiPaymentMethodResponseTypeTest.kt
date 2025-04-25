package com.ioki.passenger.api.models

import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class ApiPaymentMethodResponseTypeTest {
    internal class ApiPaymentMethodResponseTypeTestExtra {
        @Test
        fun allCasesAreTested() {
            ApiPaymentMethodType.entries.size shouldBe ApiPaymentMethodResponseTypeSerializationTest.data().size
        }
    }

    internal class ApiPaymentMethodResponseTypeSerializationTest : IokiApiModelTest() {
        @Test
        fun testPaymentMethodTypeSerialization() {
            data().forEach {
                val type = it[0] as ApiPaymentMethodType
                val json = it[1] as String
                testJsonStringCanBeConvertedToModel(type, json)
            }
        }

        companion object {
            fun data(): Collection<Array<Any>> {
                return listOf(
                    arrayOf(ApiPaymentMethodType.CASH, "\"cash\""),
                    arrayOf(ApiPaymentMethodType.PSP_PROVIDED, "\"psp_provided\""),
                    arrayOf(ApiPaymentMethodType.STRIPE, "\"stripe\""),
                    arrayOf(ApiPaymentMethodType.LOGPAY, "\"logpay\""),
                    arrayOf(
                        ApiPaymentMethodType.PUBLIC_TRANSPORT_TICKET,
                        "\"public_transport_ticket\"",
                    ),
                    arrayOf(ApiPaymentMethodType.SERVICE_CREDITS, "\"service_credits\""),
                    arrayOf(ApiPaymentMethodType.POS_PAYMENT, "\"pos_payment\""),
                    arrayOf(ApiPaymentMethodType.UNSUPPORTED, "\"UNSUPPORTED\""),
                )
            }
        }
    }
}
