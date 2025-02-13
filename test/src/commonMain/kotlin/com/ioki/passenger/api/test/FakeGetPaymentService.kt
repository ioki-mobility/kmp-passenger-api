package com.ioki.passenger.api.test

import com.ioki.passenger.api.GetPaymentService
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse
import com.ioki.passenger.api.models.ApiPersonalDiscountTypeResponse
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse
import com.ioki.passenger.api.models.ApiRedeemedPromoCodeResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeGetPaymentService : GetPaymentService {
    override suspend fun getPaymentMethods(): ApiResult<List<ApiPaymentMethodResponse>> = error("Not overridden")

    override suspend fun getServiceCreditPackages(): ApiResult<List<ApiPurchasedCreditPackageResponse>> =
        error("Not overridden")

    override suspend fun getAvailablePersonalDiscountTypes(): ApiResult<List<ApiPersonalDiscountTypeResponse>> =
        error("Not overridden")

    override suspend fun getMyPersonalDiscounts(): ApiResult<List<ApiPersonalDiscountResponse>> =
        error("Not overridden")

    override suspend fun getRedeemedPromoCodes(): ApiResult<List<ApiRedeemedPromoCodeResponse>> =
        error("Not overridden")
}
