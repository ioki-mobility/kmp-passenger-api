package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiStationsRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiStationsRequest(
                productId = "id",
                query = "query",
                xmin = 1f,
                ymin = 2f,
                xmax = 3f,
                ymax = 4f,
            ),
            stationsRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiStationsRequest("id", ""),
            stationsRequestMinimal,
        )
    }
}

private val stationsRequest =
    """
{
  "product_id": "id",
  "query": "query",
  "xmin": 1.0,
  "ymin": 2.0,
  "xmax": 3.0,
  "ymax": 4.0
}
    """

private val stationsRequestMinimal =
    """
{
  "product_id": "id",
  "query": ""
}
    """
