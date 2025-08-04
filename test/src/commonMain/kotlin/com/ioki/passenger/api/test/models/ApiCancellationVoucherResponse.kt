package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCancellationVoucherResponse
import com.ioki.passenger.api.models.ApiMoney
import kotlin.time.Instant

public fun createApiCancellationVoucherResponse(
    type: String = "",
    code: String = "",
    feeObject: ApiMoney = createApiMoney(),
    validUntil: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant = Instant.DISTANT_PAST,
): ApiCancellationVoucherResponse = ApiCancellationVoucherResponse(
    type = type,
    code = code,
    feeObject = feeObject,
    validUntil = validUntil,
    updatedAt = updatedAt,
)
