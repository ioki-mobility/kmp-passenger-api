package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.FakeHttpClient
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
import com.ioki.passenger.api.models.ApiPurchasableType
import com.ioki.passenger.api.models.ApiPurchaseFilter
import com.ioki.passenger.api.models.ApiPurchaseState
import com.ioki.passenger.api.models.ApiPurchaseType
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
import kotlinx.datetime.Clock

class IokiApiParametersTest {

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
                ticketFilter = mapOf(
                    "filter1" to "1",
                    "filter2" to "2",
                ),
                page = 2,
                perPage = 100,
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "filter" to listOf("filter"),
            "ride_id" to listOf("rideId"),
            "filter1" to listOf("1"),
            "filter2" to listOf("2"),
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

    @Test
    fun `test getPurchases parameters`() = runTest {
        val untilTime = Clock.System.now()
        val parameters = setupParameterTest {
            it.getPurchases(
                filter = ApiPurchaseFilter(
                    purchasableId = "purchasableId",
                    purchasableType = ApiPurchasableType.BOOKING,
                    state = ApiPurchaseState.FAILED,
                    page = 2,
                    since = Instant.fromEpochSeconds(671371675),
                    until = untilTime,
                    filter = ApiPurchaseType.DEBIT,
                    order = ApiPurchaseFilter.Order.DESCENDING,
                    orderBy = ApiPurchaseFilter.OrderBy.UPDATED_AT,
                    perPage = 100,
                ),
            )
        }

        parameters.toMap() shouldContainExactly mapOf(
            "page" to listOf("2"),
            "per_page" to listOf("100"),
            "purchasable_id" to listOf("purchasableId"),
            "purchasable_type" to listOf("Booking"),
            "state" to listOf("failed"),
            "since" to listOf("1991-04-11T12:07:55Z"),
            "until" to listOf(untilTime.toString()),
            "filter" to listOf("debit"),
            "order" to listOf("desc"),
            "order_by" to listOf("updated_at"),
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
