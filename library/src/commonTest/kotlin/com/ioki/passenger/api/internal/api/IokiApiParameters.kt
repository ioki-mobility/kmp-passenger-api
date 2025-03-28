package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.FakeHttpClient
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertTrue

class IokiApiParameters {

    @Test
    fun `test getRides parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getRides(type = "type", page = 5, perPage = 10)
        }

        assertTrue(parameters.contains("filter", "type"))
        assertTrue(parameters.contains("page", "5"))
        assertTrue(parameters.contains("per_page", "10"))
    }

    @Test
    fun `test rideSeriesList parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getRideSeriesList(page = 5)
        }

        assertTrue(parameters.contains("page", "5"))
        assertTrue(parameters.contains("per_page", "10"))
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

        assertTrue(parameters.contains("time", time.toString()))
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

        assertTrue(parameters.contains("query", "1.0"))
        assertTrue(parameters.contains("product_id", "productId"))
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

        assertTrue(parameters.contains("query", "1.0"))
        assertTrue(parameters.contains("product_id", "productId"))
        assertTrue(parameters.contains("xmin", "1.2"))
        assertTrue(parameters.contains("xmax", "1.0"))
        assertTrue(parameters.contains("ymin", "0.2"))
        assertTrue(parameters.contains("ymax", "2.4"))
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

        assertTrue(parameters.contains("filter", "filter"))
        assertTrue(parameters.contains("ride_id", "rideId"))
        assertTrue(parameters.contains("page", "2"))
        assertTrue(parameters.contains("per_page", "100"))
    }

    @Test
    fun `test getActiveUserTicketingVouchers parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getActiveUserTicketingVouchers(
                page = 2,
                perPage = 100,
            )
        }

        assertTrue(parameters.contains("page", "2"))
        assertTrue(parameters.contains("per_page", "100"))
    }

    @Test
    fun `test getInactiveTicketingVouchers parameters`() = runTest {
        val parameters = setupParameterTest {
            it.getInactiveUserTicketingVouchers(
                page = 2,
                perPage = 100,
            )
        }

        assertTrue(parameters.contains("page", "2"))
        assertTrue(parameters.contains("per_page", "100"))
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
        println(requestData.url)
        return requestData.url.parameters
    }
}
