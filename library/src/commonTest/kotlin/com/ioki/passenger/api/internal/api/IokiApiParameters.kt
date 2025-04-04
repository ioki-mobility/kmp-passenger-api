package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.FakeHttpClient
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
import io.kotest.matchers.maps.shouldContainExactly
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.util.toMap
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.Test

class IokiApiParameters {

    @Test
    fun `test getRides parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getRides(type = "type", page = 5, perPage = 10)
        }

        parameters.toMap() shouldContainExactly mapOf(
            "filter" to listOf("type"),
            "page" to listOf("5"),
            "per_page" to listOf("10"),
        )
    }

    @Test
    fun `test rideSeriesList parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getRideSeriesList(page = 5)
        }

        parameters.toMap() shouldContainExactly mapOf(
            "page" to listOf("5"),
            "per_page" to listOf("10"),
        )
    }

    @Test
    fun `test requestPublicTransportSchedules parameters`() = runTest {
        val time = Instant.DISTANT_PAST
        val parameters = setupParameterTest {
            it.requestPublicTransportSchedules(
                url = "https://ioki.com",
                time = time,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "time" to listOf(time.toString()),
        )
    }

    @Test
    fun `test getStations with empty x and y parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getStations(
                query = "1.0",
                productId = "productId",
                xmin = null,
                xmax = null,
                ymin = null,
                ymax = null,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "query" to listOf("1.0"),
            "product_id" to listOf("productId"),
        )
    }

    @Test
    fun `test getStations with x and y parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getStations(
                query = "1.0",
                productId = "productId",
                xmin = 1.2f,
                xmax = 1.0f,
                ymin = 0.2f,
                ymax = 2.4f,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "query" to listOf("1.0"),
            "product_id" to listOf("productId"),
            "xmin" to listOf("1.2"),
            "xmax" to listOf("1.0"),
            "ymin" to listOf("0.2"),
            "ymax" to listOf("2.4"),
        )
    }

    @Test
    fun `test getAllTicketingProducts parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getAllTicketingProducts(
                filter = "filter",
                rideId = "rideId",
                page = 2,
                perPage = 100,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "filter" to listOf("filter"),
            "ride_id" to listOf("rideId"),
            "page" to listOf("2"),
            "per_page" to listOf("100"),
        )
    }

    @Test
    fun `test getActiveUserTicketingVouchers parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getActiveUserTicketingVouchers(
                page = 2,
                perPage = 100,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "filter" to listOf("active"),
            "page" to listOf("2"),
            "per_page" to listOf("100"),
        )
    }

    @Test
    fun `test getInactiveTicketingVouchers parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getInactiveUserTicketingVouchers(
                page = 2,
                perPage = 100,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "filter" to listOf("inactive"),
            "page" to listOf("2"),
            "per_page" to listOf("100"),
        )
    }

    private suspend fun setupParameterTest(apiCallToTest: suspend (IokiApi) -> HttpResponse): Parameters {
        val client = FakeHttpClient(HttpStatusCode.OK, ByteReadChannel.Empty)
        val api = IokiApi(
            client,
            object : AuthHeaderProvider {
                override fun provide(): String = "Doesn't matter"
            },
        )

        apiCallToTest(api)

        val requestData = (client.engine as MockEngine).requestHistory.first()
        return requestData.url.parameters
    }
}
