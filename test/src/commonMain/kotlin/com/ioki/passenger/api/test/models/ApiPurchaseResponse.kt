package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPurchaseResponse
import com.ioki.passenger.api.models.ApiPurchaseResponse.ChargeSplits
import com.ioki.passenger.api.models.ApiPurchaseResponse.Invoice
import com.ioki.passenger.api.models.ApiPurchaseResponse.PaymentMethod
import com.ioki.passenger.api.models.ApiPurchaseResponse.CreatorType
import com.ioki.passenger.api.models.ApiPurchasableType
import com.ioki.passenger.api.models.ApiPurchaseState
import com.ioki.passenger.api.models.ApiPurchaseType
import kotlinx.datetime.Instant

public fun createApiPurchaseResponse(
    purchasableType: ApiPurchasableType = ApiPurchasableType.UNSUPPORTED,
    purchaseType: ApiPurchaseType = ApiPurchaseType.UNSUPPORTED,
    state: ApiPurchaseState = ApiPurchaseState.UNSUPPORTED,
    purchasableId: String = "",
    debitPurchaseId: String? = null,
    creatorId: String? = null,
    rideId: String? = null,
    creatorType: CreatorType? = null,
    createdAt: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant? = null,
    forfeitedAt: Instant? = null,
    succeededAt: Instant? = null,
    reason: String? = null,
    paymentMethod: PaymentMethod? = null,
    chargeSplits: List<ChargeSplits> = emptyList(),
    amount: ApiMoney = createApiMoney(),
    invoices: List<Invoice> = emptyList(),
): ApiPurchaseResponse = ApiPurchaseResponse(
    purchasableId = purchasableId,
    debitPurchaseId = debitPurchaseId,
    creatorId = creatorId,
    rideId = rideId,
    purchasableType = purchasableType,
    purchaseType = purchaseType,
    creatorType = creatorType,
    createdAt = createdAt,
    updatedAt = updatedAt,
    forfeitedAt = forfeitedAt,
    succeededAt = succeededAt,
    paymentMethod = paymentMethod,
    chargeSplits = chargeSplits,
    state = state,
    amount = amount,
    reason = reason,
    invoices = invoices,
)
