package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse

public fun createApiPurchasedCreditPackageResponse(
    id: String = "",
    balance: ApiMoney = createApiMoney(),
): ApiPurchasedCreditPackageResponse = ApiPurchasedCreditPackageResponse(
    id = id,
    balance = balance,
)
