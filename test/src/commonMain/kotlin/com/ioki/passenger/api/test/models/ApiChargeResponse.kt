package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiChargeResponse
import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import kotlin.time.Instant

public fun createApiChargeResponse(
    id: String = "",
    chargeType: ApiChargeResponse.ChargeType = ApiChargeResponse.ChargeType.UNSUPPORTED,
    userId: String = "",
    paymentChargeId: String? = null,
    paymentMethod: ApiPaymentMethodResponse? = null,
    reservation: Boolean = false,
    state: ApiChargeResponse.State = ApiChargeResponse.State.NOT_INITIATED,
    amount: ApiMoney = createApiMoney(),
    receipt: ApiChargeResponse.Receipt? = null,
    pendingAction: ApiChargeResponse.PendingAction? = null,
    earliestReservableAt: Instant? = null,
): ApiChargeResponse = ApiChargeResponse(
    id = id,
    chargeType = chargeType,
    userId = userId,
    paymentChargeId = paymentChargeId,
    paymentMethod = paymentMethod,
    reservation = reservation,
    state = state,
    amount = amount,
    receipt = receipt,
    pendingAction = pendingAction,
    earliestReservableAt = earliestReservableAt,
)

public fun createApiChargeResponsePendingAction(
    action: ApiChargeResponse.PendingAction.Action = ApiChargeResponse.PendingAction.Action.Unsupported,
): ApiChargeResponse.PendingAction = ApiChargeResponse.PendingAction(
    action = action,
)

public fun createApiChargeResponsePendingActionOpenUrl(
    url: String = "",
): ApiChargeResponse.PendingAction.Action.OpenUrl = ApiChargeResponse.PendingAction.Action.OpenUrl(
    url = url,
)
