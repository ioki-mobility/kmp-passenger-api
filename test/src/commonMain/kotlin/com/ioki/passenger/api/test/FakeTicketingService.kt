package com.ioki.passenger.api.test

import com.ioki.passenger.api.TicketingService
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest
import com.ioki.passenger.api.models.ApiTicketingProductFilterType
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import com.ioki.passenger.api.models.ApiTicketingShopConfigurationResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeTicketingService : TicketingService {
    override suspend fun getActiveUserTicketingVouchers(page: Int): ApiResult<List<ApiTicketingVoucherResponse>> =
        error("Not overridden")

    override suspend fun getInactiveUserTicketingVouchers(page: Int): ApiResult<List<ApiTicketingVoucherResponse>> =
        error("Not overridden")

    override suspend fun getShopConfiguration(): ApiResult<ApiTicketingShopConfigurationResponse> =
        error("Not overridden")

    override suspend fun getUserTicketingVoucher(ticketVoucherId: String): ApiResult<ApiTicketingVoucherResponse> =
        error("Not overridden")

    override suspend fun getAllTicketingProducts(
        type: ApiTicketingProductFilterType,
        rideId: String?,
        page: Int,
    ): ApiResult<List<ApiTicketingProductResponse>> = error("Not overridden")

    override suspend fun purchaseTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): ApiResult<ApiTicketingVoucherResponse> = error("Not overridden")

    override suspend fun renewTicketingVoucher(
        id: String,
        request: ApiRenewTicketingVoucherRequest,
    ): ApiResult<ApiTicketingVoucherResponse> = error("Not overridden")

    override suspend fun cancelTicketingVoucher(voucherId: String): ApiResult<ApiTicketingVoucherResponse> =
        error("Not overridden")
}
