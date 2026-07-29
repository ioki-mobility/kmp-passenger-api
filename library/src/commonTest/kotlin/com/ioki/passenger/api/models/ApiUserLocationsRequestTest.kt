package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.time.Instant

internal class ApiUserLocationsRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocationsRequest(
                page = 1,
                since = Instant.parse("2026-01-01T00:00:00Z"),
                until = Instant.parse("2026-07-09T23:59:59Z"),
                order = ApiUserLocationsRequest.Order.DESCENDING,
                orderBy = ApiUserLocationsRequest.OrderBy.CREATED_AT,
                perPage = 25,
            ),
            userLocationsRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocationsRequest(page = 1),
            userLocationsRequestMinimal,
        )
    }
}

private val userLocationsRequest: String =
    """
        {
            "page": 1,
            "since": "2026-01-01T00:00:00Z",
            "until": "2026-07-09T23:59:59Z",
            "order": "desc",
            "order_by": "created_at",
            "per_page": 25
        }
    """.trimIndent()
private val userLocationsRequestMinimal: String =
    """
        {"page":1}
    """.trimIndent()
