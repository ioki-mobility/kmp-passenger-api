package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiMoney
import kotlin.test.Test
import kotlin.time.Instant

internal class ApiChargeResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiChargeResponse(
                id = "chargeId",
                chargeType = ApiChargeResponse.ChargeType.PAYMENT,
                userId = "userId",
                paymentChargeId = "paymentChargeId",
                paymentMethod = null,
                reservation = true,
                state = ApiChargeResponse.State.ACTION_REQUIRED,
                amount = createApiMoney(amount = 90, currency = "EUR"),
                receipt = ApiChargeResponse.Receipt(
                    id = "receiptId",
                    chargeId = "chargeId",
                    attachmentUrl = "https://example.com/receipt.pdf",
                    createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                    updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                ),
                pendingAction = ApiChargeResponse.PendingAction(
                    action = ApiChargeResponse.PendingAction.Action.OpenUrl(
                        url = "https://example.com/challenge",
                    ),
                ),
            ),
            chargeResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiChargeResponse(
                id = "chargeId",
                chargeType = ApiChargeResponse.ChargeType.REFUND,
                userId = "userId",
                paymentChargeId = null,
                paymentMethod = null,
                reservation = false,
                state = ApiChargeResponse.State.PENDING,
                amount = createApiMoney(amount = 0, currency = "EUR"),
                receipt = null,
                pendingAction = null,
            ),
            chargeResponseMinimal,
        )
    }

    @Test
    fun serializationUnsupportedPendingActionActionType() {
        testJsonStringCanBeConvertedToModel(
            ApiChargeResponse(
                id = "chargeId",
                chargeType = ApiChargeResponse.ChargeType.PAYMENT,
                userId = "userId",
                paymentChargeId = "paymentChargeId",
                paymentMethod = null,
                reservation = true,
                state = ApiChargeResponse.State.ACTION_REQUIRED,
                amount = createApiMoney(amount = 90, currency = "EUR"),
                receipt = null,
                pendingAction = ApiChargeResponse.PendingAction(
                    action = ApiChargeResponse.PendingAction.Action.Unsupported,
                ),
            ),
            chargeResponseUnsupportedPendingActionActionType,
        )
    }
}

private val chargeResponse =
    """
{
    "id": "chargeId",
    "charge_type": "payment",
    "user_id": "userId",
    "payment_charge_id": "paymentChargeId",
    "payment_method": null,
    "reservation": true,
    "state": "action_required",
    "amount": {
        "amount": 90,
        "currency": "EUR"
    },
    "receipt": {
        "id": "receiptId",
        "charge_id": "chargeId",
        "attachment_url": "https://example.com/receipt.pdf",
        "created_at": "2023-07-19T13:17:42Z",
        "updated_at": "2023-07-20T13:17:42Z"
    },
    "pending_action": {
        "type": "charge_challenge",
        "action": {
            "type": "open_url",
            "url": "https://example.com/challenge"
        }
    }
}
"""

private val chargeResponseMinimal =
    """
{
    "id": "chargeId",
    "charge_type": "refund",
    "user_id": "userId",
    "payment_charge_id": null,
    "payment_method": null,
    "reservation": false,
    "state": "pending",
    "amount": {
        "amount": 0,
        "currency": "EUR"
    },
    "receipt": null
}
"""

private val chargeResponseUnsupportedPendingActionActionType =
    """
{
    "id": "chargeId",
    "charge_type": "payment",
    "user_id": "userId",
    "payment_charge_id": "paymentChargeId",
    "payment_method": null,
    "reservation": true,
    "state": "action_required",
    "amount": {
        "amount": 90,
        "currency": "EUR"
    },
    "receipt": null,
    "pending_action": {
        "type": "charge_challenge",
        "action": {
            "type": "some_future_challenge_type",
            "some_unknown_field": "someValue"
        }
    }
}
"""
