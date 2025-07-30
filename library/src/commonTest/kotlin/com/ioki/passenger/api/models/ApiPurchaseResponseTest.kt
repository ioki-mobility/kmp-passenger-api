package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiMoney
import com.ioki.passenger.api.test.models.createApiPaymentMethodResponseSummary
import kotlin.test.Test
import kotlin.time.Instant

internal class ApiPurchaseResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchaseResponse(
                id = "purId",
                purchasableId = "purchasableId",
                debitPurchaseId = "debitPurchaseId",
                creatorId = "creatorId",
                rideId = "rideId",
                purchasableTitle = "purchasableTitle",
                purchasableDescription = "purchasableDescription",
                purchasableType = ApiPurchasableType.TIP,
                purchaseType = ApiPurchaseType.CREDIT,
                creatorType = ApiPurchaseResponse.CreatorType.USER,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                claimableAt = Instant.parse("2023-07-19T15:17:42Z"),
                forfeitedAt = Instant.parse("2023-07-20T11:17:42Z"),
                succeededAt = Instant.parse("2023-07-20T13:17:42Z"),
                paymentMethod = ApiPaymentMethodResponse(
                    paymentMethodType = ApiPaymentMethodType.SERVICE_CREDITS,
                    id = "paymentMethodId",
                    summary = createApiPaymentMethodResponseSummary(
                        kind = ApiPaymentMethodResponse.Summary.Kind.PAYPAL,
                        title = "paypalTitle",
                    ),
                ),
                chargeSplits = listOf(
                    ApiPurchaseResponse.ChargeSplits(
                        purchaseId = "purchaseId",
                        amount = ApiMoney(amount = 140, currency = "EUR"),
                        charge = ApiPurchaseResponse.Charge(
                            chargeType = ApiPurchaseResponse.Charge.ChargeType.PAYMENT,
                            userId = "userId",
                            paymentChargeId = "paymentChargeId",
                            paymentMethod = null,
                            purchaseIds = listOf("purchaseId1", "purchaseId2"),
                            reservation = true,
                            state = ApiPurchaseResponse.Charge.State.PENDING,
                            amount = ApiMoney(amount = 90, currency = "EUR"),
                            receipt = ApiPurchaseResponse.Charge.Receipt(
                                id = "receiptId",
                                chargeId = "chargeId",
                                attachmentUrl = "https://example.com/receipt.pdf",
                                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                                updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                            ),
                        ),
                    ),
                ),
                state = ApiPurchaseState.SUCCEEDED,
                amount = createApiMoney(amount = 100, currency = "EUR"),
                giftedAmount = createApiMoney(amount = 10, currency = "EUR"),
                reason = "reason123",
                invoice = ApiPurchaseResponse.Invoice(
                    id = "invoiceId",
                    userId = "userId",
                    purchaseId = "purchaseId",
                    attachmentUrl = "https://example.com/invoice.pdf",
                    createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                    updatedAt = Instant.parse("2023-07-20T13:17:42Z"),
                ),
            ),
            purchaseResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiPurchaseResponse(
                id = "purId",
                purchasableId = "purchasableId",
                purchasableType = ApiPurchasableType.BOOKING,
                purchaseType = ApiPurchaseType.DEBIT,
                createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                chargeSplits = emptyList(),
                state = ApiPurchaseState.PENDING,
                amount = ApiMoney(amount = 25, currency = "USD"),
                giftedAmount = ApiMoney(amount = 0, currency = "USD"),
                invoice = null,
                purchasableTitle = null,
                purchasableDescription = null,
                reason = null,
                debitPurchaseId = null,
                creatorId = null,
                rideId = null,
                creatorType = null,
                updatedAt = null,
                claimableAt = null,
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
    "id": "purId",
    "purchasable_id": "purchasableId",
    "purchasable_title": "purchasableTitle",
    "purchasable_description": "purchasableDescription",
    "debit_purchase_id": "debitPurchaseId",
    "creator_id": "creatorId",
    "ride_id": "rideId",
    "purchasable_type": "Tip",
    "purchase_type": "credit",
    "creator_type": "User",
    "created_at": "2023-07-19T13:17:42Z",
    "updated_at": "2023-07-20T13:17:42Z",
    "claimable_at": "2023-07-19T15:17:42Z",
    "forfeited_at": "2023-07-20T11:17:42Z",
    "succeeded_at": "2023-07-20T13:17:42Z",
    "payment_method": {
        "payment_method_type": "service_credits",
        "id": "paymentMethodId",
        "summary": {
            "kind": "paypal",
            "title": "paypalTitle"
        }
    },
    "charge_splits": [
        {
        "purchase_id": "purchaseId",
        "amount": {
            "amount": 140,
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
                "amount": 90,
                "currency": "EUR"
            },
            "receipt": {
                "id": "receiptId",
                "charge_id": "chargeId",
                "attachment_url": "https://example.com/receipt.pdf",
                "created_at": "2023-07-19T13:17:42Z",
                "updated_at": "2023-07-20T13:17:42Z"
            }
        }
        }
    ],
    "state": "succeeded",
    "amount": {
        "amount": 100,
        "currency": "EUR"
    },
    "gifted_amount": {
        "amount": 10,
        "currency": "EUR"
    },
    "reason": "reason123",
    "invoice": {
        "id": "invoiceId",
        "user_id": "userId",
        "purchase_id": "purchaseId",
        "attachment_url": "https://example.com/invoice.pdf",
        "created_at": "2023-07-19T13:17:42Z",
        "updated_at": "2023-07-20T13:17:42Z"
    }
}
"""

private val purchaseResponseMinimal =
"""
{
    "id": "purId",
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
    "gifted_amount": {
        "amount": 0,
        "currency": "USD"
    }
}
"""
