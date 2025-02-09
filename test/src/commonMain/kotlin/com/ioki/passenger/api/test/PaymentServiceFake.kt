package com.ioki.passenger.api.test

import com.ioki.passenger.api.PaymentService
import com.ioki.passenger.api.models.ApiFailedPaymentRequest
import com.ioki.passenger.api.models.ApiFailedPaymentResponse
import com.ioki.passenger.api.models.ApiPersonalDiscountPurchaseRequest
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest
import com.ioki.passenger.api.result.ApiResult

public open class PaymentServiceFake : PaymentService {
    override suspend fun detachPaymentMethod(paymentMethodId: String): ApiResult<Unit> = error("Not overridden")

    override suspend fun purchaseCreditPackage(
        purchasingPackage: ApiPurchasingCreditPackageRequest,
    ): ApiResult<ApiPurchasedCreditPackageResponse> = error("Not overridden")

    override suspend fun purchasePersonalDiscount(
        purchaseRequest: ApiPersonalDiscountPurchaseRequest,
    ): ApiResult<ApiPersonalDiscountResponse> = error("Not overridden")

    override suspend fun payFailedPayments(request: ApiFailedPaymentRequest): ApiResult<ApiFailedPaymentResponse> =
        error("Not overridden")
}
