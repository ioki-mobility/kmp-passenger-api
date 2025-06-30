package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiPurchasableType
import com.ioki.passenger.api.models.ApiPurchaseResponse
import com.ioki.passenger.api.models.ApiPurchaseResponse.ChargeSplits
import com.ioki.passenger.api.models.ApiPurchaseResponse.CreatorType
import com.ioki.passenger.api.models.ApiPurchaseResponse.Invoice
import com.ioki.passenger.api.models.ApiPurchaseState
import com.ioki.passenger.api.models.ApiPurchaseType
import kotlinx.datetime.Instant

public fun createApiPurchaseResponse(
    id: String = "",
    purchasableType: ApiPurchasableType = ApiPurchasableType.UNSUPPORTED,
    purchaseType: ApiPurchaseType = ApiPurchaseType.UNSUPPORTED,
    state: ApiPurchaseState = ApiPurchaseState.UNSUPPORTED,
    purchasableId: String = "",
    purchasableTitle: String? = null,
    purchasableDescription: String? = null,
    debitPurchaseId: String? = null,
    creatorId: String? = null,
    rideId: String? = null,
    creatorType: CreatorType? = null,
    createdAt: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant? = null,
    claimableAt: Instant? = null,
    forfeitedAt: Instant? = null,
    succeededAt: Instant? = null,
    reason: String? = null,
    paymentMethod: ApiPaymentMethodResponse? = null,
    chargeSplits: List<ChargeSplits> = emptyList(),
    amount: ApiMoney = createApiMoney(),
    giftedAmount: ApiMoney = createApiMoney(),
    invoice: Invoice? = null,
): ApiPurchaseResponse = ApiPurchaseResponse(
    id = id,
    purchasableId = purchasableId,
    debitPurchaseId = debitPurchaseId,
    creatorId = creatorId,
    rideId = rideId,
    purchasableTitle = purchasableTitle,
    purchasableDescription = purchasableDescription,
    purchasableType = purchasableType,
    purchaseType = purchaseType,
    creatorType = creatorType,
    createdAt = createdAt,
    updatedAt = updatedAt,
    claimableAt = claimableAt,
    forfeitedAt = forfeitedAt,
    succeededAt = succeededAt,
    paymentMethod = paymentMethod,
    chargeSplits = chargeSplits,
    state = state,
    amount = amount,
    giftedAmount = giftedAmount,
    reason = reason,
    invoice = invoice,
)

public fun createApiPurchaseResponseChargeSplits(
    purchaseId: String = "",
    amount: ApiMoney = createApiMoney(),
    charge: ApiPurchaseResponse.Charge = createApiPurchaseResponseCharge(),
): ChargeSplits = ChargeSplits(
    purchaseId = purchaseId,
    amount = amount,
    charge = charge,
)

public fun createApiPurchaseResponseCharge(
    chargeType: ApiPurchaseResponse.Charge.ChargeType = ApiPurchaseResponse.Charge.ChargeType.UNSUPPORTED,
    userId: String = "",
    paymentChargeId: String? = null,
    paymentMethod: ApiPaymentMethodResponse? = null,
    purchaseIds: List<String> = emptyList(),
    reservation: Boolean = false,
    state: ApiPurchaseResponse.Charge.State = ApiPurchaseResponse.Charge.State.NOT_INITIATED,
    amount: ApiMoney = createApiMoney(),
    receipt: ApiPurchaseResponse.Charge.Receipt? = null,
): ApiPurchaseResponse.Charge = ApiPurchaseResponse.Charge(
    chargeType = chargeType,
    userId = userId,
    paymentChargeId = paymentChargeId,
    paymentMethod = paymentMethod,
    purchaseIds = purchaseIds,
    reservation = reservation,
    state = state,
    amount = amount,
    receipt = receipt,
)
