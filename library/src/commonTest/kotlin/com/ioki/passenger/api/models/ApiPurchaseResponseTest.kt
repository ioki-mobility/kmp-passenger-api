package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiMoney
import kotlin.test.Test
import kotlinx.datetime.Instant

internal class ApiPurchaseResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchaseResponse(
                purchasableId = "purchasableId",
                debitPurchaseId = "debitPurchaseId",
                creatorId = "creatorId",
                rideId = "rideId",
                purchasableType = ApiPurchasableType.TIP,
                purchaseType = ApiPurchaseType.CREDIT,
                creatorType = ApiPurchaseResponse.CreatorType.USER,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                forfeitedAt = Instant.parse("2023-07-20T11:17:42Z"),
                succeededAt = Instant.parse("2023-07-20T13:17:42Z"),
                paymentMethod = ApiPurchaseResponse.PaymentMethod(
                    paymentMethodType = ApiPaymentMethodType.SERVICE_CREDITS,
                    id = "paymentMethodId",
                ),
                chargeSplits = listOf(
                    ApiPurchaseResponse.ChargeSplits(
                        purchaseId = "purchaseId",
                        amount = ApiMoney(amount = 100, currency = "EUR"),
                        charge = ApiPurchaseResponse.Charge(
                            chargeType = ApiPurchaseResponse.Charge.ChargeType.PAYMENT,
                            userId = "userId",
                            paymentChargeId = "paymentChargeId",
                            paymentMethod = null,
                            purchaseIds = listOf("purchaseId1", "purchaseId2"),
                            reservation = true,
                            state = ApiPurchaseResponse.Charge.State.PENDING,
                            amount = ApiMoney(amount = 100, currency = "EUR"),
                            receipt = null,
                        ),
                    ),
                ),
                state = ApiPurchaseState.SUCCEEDED,
                amount = createApiMoney(amount = 100, currency = "EUR"),
                reason = "reason123",
                invoices = listOf(
                    ApiPurchaseResponse.Invoice(
                        id = "invoiceId",
                        userId = "userId",
                        purchaseId = "purchaseId",
                        attachmentUrl = "https://example.com/invoice.pdf",
                        createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                        updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                    ),
                )
            ),
            purchaseResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchaseResponse(
                purchasableId = "purchasableId",
                purchasableType = ApiPurchasableType.BOOKING,
                purchaseType = ApiPurchaseType.DEBIT,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                chargeSplits = emptyList(),
                state = ApiPurchaseState.PENDING,
                amount = ApiMoney(amount = 25, currency ="USD"),
                invoices = emptyList(),
                reason = null,
                debitPurchaseId = null,
                creatorId = null,
                rideId = null,
                creatorType = null,
                updatedAt = null,
                forfeitedAt = null,
                succeededAt = null,
                paymentMethod = null,
            ),
            purchaseResponseMinimal,
        )
    }
}

private val purchaseResponse =
"""
{
    "purchasable_id": "purchasableId",
    "debit_purchase_id": "debitPurchaseId",
    "creator_id": "creatorId",
    "ride_id": "rideId",
    "purchasable_type": "Tip",
    "purchase_type": "credit",
    "creator_type": "User",
    "created_at": "2023-07-19T13:17:42Z",
    "updated_at": "2023-07-20T13:17:42Z",
    "forfeited_at": "2023-07-20T11:17:42Z",
    "succeeded_at": "2023-07-20T13:17:42Z",
    "payment_method": {
        "payment_method_type": "service_credits",
        "id": "paymentMethodId"
    },
    "charge_splits": [
        {
        "purchase_id": "purchaseId",
        "amount": {
            "amount": 100,
            "currency": "EUR"
        },
        "charge": {
            "charge_type": "payment",
            "user_id": "userId",
            "payment_charge_id": "paymentChargeId",
            "payment_method": null,
            "purchase_ids": [
                "purchaseId1",
                "purchaseId2"
            ],
            "reservation": true,
            "state": "pending",
            "amount": {
                "amount": 100,
                "currency": "EUR"
            },
            "receipt": null
        }
        }
    ],
    "state": "succeeded",
    "amount": {
        "amount": 100,
        "currency": "EUR"
    },
    "reason": "reason123",
    "invoices": [
        {
            "id": "invoiceId",
            "user_id": "userId",
            "purchase_id": "purchaseId",
            "attachment_url": "https://example.com/invoice.pdf",
            "created_at": "2023-07-19T13:17:42Z",
            "updated_at": "2023-07-20T13:17:42Z"
        }
    ]
}
"""

private val purchaseResponseMinimal =
"""
{
    "purchasable_id": "purchasableId",
    "purchasable_type": "Booking",
    "purchase_type": "debit",
    "created_at": "2023-07-19T13:17:42Z",
    "charge_splits": [],
    "state": "pending",
    "amount": {
        "amount": 25,
        "currency": "USD"
    },
    "invoices": []
}
"""
