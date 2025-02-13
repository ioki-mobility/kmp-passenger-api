package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse

public fun createApiPurchasedCreditPackageResponse(
    balance: ApiMoney = createApiMoney(),
): ApiPurchasedCreditPackageResponse = ApiPurchasedCreditPackageResponse(
    balance = balance,
)
