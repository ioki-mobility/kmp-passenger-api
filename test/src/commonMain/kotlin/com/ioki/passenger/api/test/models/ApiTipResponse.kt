package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiTipResponse

public fun createApiTipResponse(id: String = "", amount: ApiMoney = createApiMoney()): ApiTipResponse = ApiTipResponse(
    id = id,
    amount = amount,
)
