package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.FakeHttpClient
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
import com.ioki.passenger.api.models.ApiPurchasableType
import com.ioki.passenger.api.models.ApiPurchaseFilter
import com.ioki.passenger.api.models.ApiPurchaseState
import com.ioki.passenger.api.models.ApiPurchaseType
import com.ioki.passenger.api.models.toStringValues
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.datetime.Clock

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

    @Test
    fun `test getPurchases parameters`() = runTest {
        val untilTime = Clock.System.now()
        val parameters = setupParameterTest {
            it.getPurchases(
                filters = ApiPurchaseFilter(
                    purchasableId = "purchasableId",
                    purchasableType = ApiPurchasableType.BOOKING,
                    state = ApiPurchaseState.FAILED,
                    page = "2",
                    since = Instant.fromEpochSeconds(671371675),
                    until = untilTime,
                    filter = ApiPurchaseType.DEBIT,
                    order = ApiPurchaseFilter.Order.DESCENDING,
                    orderBy = ApiPurchaseFilter.OrderBy.UPDATED_AT,
                    perPage = "100",
                ).toStringValues(),
            )
        }

        assertTrue(parameters.contains(name = "page", value = "2"))
        assertTrue(parameters.contains(name = "per_page", value = "100"))
        assertTrue(parameters.contains(name = "purchasable_id", value = "purchasableId"))
        assertTrue(parameters.contains(name = "purchasable_type", value = "Booking"))
        assertTrue(parameters.contains(name = "state", value = "failed"))
        assertTrue(parameters.contains(name = "since", value = "1991-04-11T12:07:55Z"))
        assertTrue(parameters.contains(name = "until", value = untilTime.toString()))
        assertTrue(parameters.contains(name = "filter", value = "debit"))
        assertTrue(parameters.contains(name = "order", value = "desc"))
        assertTrue(parameters.contains(name = "order_by", value = "updated_at"))
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
