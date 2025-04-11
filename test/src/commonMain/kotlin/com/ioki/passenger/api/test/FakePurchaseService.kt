package com.ioki.passenger.api.test

import com.ioki.passenger.api.PurchaseService
import com.ioki.passenger.api.models.ApiPurchaseFilter
import com.ioki.passenger.api.models.ApiPurchaseResponse
import com.ioki.passenger.api.models.ApiResettleDebitsRequest
import com.ioki.passenger.api.models.ApiSettleDebitRequest
import com.ioki.passenger.api.result.ApiResult

public open class FakePurchaseService : PurchaseService {
    override suspend fun getPurchases(filter: ApiPurchaseFilter): ApiResult<List<ApiPurchaseResponse>> =
        error("Not overridden")

    override suspend fun getPurchase(purchaseId: String): ApiResult<ApiPurchaseResponse> = error("Not overridden")

    override suspend fun settleDebit(
        purchaseId: String,
        request: ApiSettleDebitRequest,
    ): ApiResult<ApiPurchaseResponse> = error("Not overridden")

    override suspend fun resettleDebits(request: ApiResettleDebitsRequest): ApiResult<List<ApiPurchaseResponse>> =
        error("Not overridden")
}
