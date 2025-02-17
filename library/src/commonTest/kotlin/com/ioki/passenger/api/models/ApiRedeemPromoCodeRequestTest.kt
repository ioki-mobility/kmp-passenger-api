package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRedeemPromoCodeRequestTest : IokiApiModelTest() {
    @Test
    fun `serialization of promo type`() {
        testJsonStringCanBeConvertedToModel(
            ApiRedeemPromoCodeRequest("summer_special"),
            redeemPromoCodeRequest,
        )
    }

    @Test
    fun `serialization of service credit type`() {
        testJsonStringCanBeConvertedToModel(
            ApiRedeemPromoCodeRequest("summer_special"),
            redeemPromoCodeCreditRequest,
        )
    }
}

private val redeemPromoCodeRequest =
    """
{
  "code": "summer_special"
}
"""

private val redeemPromoCodeCreditRequest =
    """
{
  "code": "summer_special"
}
"""
