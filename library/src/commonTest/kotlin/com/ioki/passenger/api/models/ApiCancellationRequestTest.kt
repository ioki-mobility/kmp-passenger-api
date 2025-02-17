package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiCancellationRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiCancellationRequest(2, "Code", "statement_id"),
            cancellation,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiCancellationRequest(2, null, null),
            minimalCancellation,
        )
    }
}

private val cancellation =
    """
{
  "ride_version": 2,
  "code": "Code",
  "cancellation_statement_id": "statement_id"
}
"""

private val minimalCancellation =
    """
{
  "ride_version": 2
}
"""
