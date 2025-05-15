package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPurchaseResponse(
    val id: String,
    @SerialName(value = "purchasable_id") val purchasableId: String,
    @SerialName(value = "purchasable_title") val purchasableTitle: String?,
    @SerialName(value = "purchasable_description") val purchasableDescription: String?,
    @SerialName(value = "debit_purchase_id") val debitPurchaseId: String?,
    @SerialName(value = "creator_id") val creatorId: String?,
    @SerialName(value = "ride_id") val rideId: String?,
    @SerialName(value = "purchasable_type") val purchasableType: ApiPurchasableType,
    @SerialName(value = "purchase_type") val purchaseType: ApiPurchaseType,
    @SerialName(value = "creator_type") val creatorType: CreatorType?,
    @SerialName(value = "created_at") val createdAt: Instant,
    @SerialName(value = "updated_at") val updatedAt: Instant?,
    @SerialName(value = "forfeited_at") val forfeitedAt: Instant?,
    @SerialName(value = "succeeded_at") val succeededAt: Instant?,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodResponse?,
    @SerialName(value = "charge_splits") val chargeSplits: List<ChargeSplits>,
    val state: ApiPurchaseState,
    val amount: ApiMoney,
    val reason: String?,
    val invoices: List<Invoice>,
) {
    @Serializable
    public data class ChargeSplits(
        @SerialName(value = "purchase_id") val purchaseId: String,
        val amount: ApiMoney,
        val charge: Charge,
    )

    @Serializable
    public data class Charge(
        @SerialName(value = "charge_type") val chargeType: ChargeType,
        @SerialName(value = "user_id") val userId: String,
        @SerialName(value = "payment_charge_id") val paymentChargeId: String?,
        @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodResponse?,
        @SerialName(value = "purchase_ids") val purchaseIds: List<String>,
        val reservation: Boolean,
        val state: State,
        val amount: ApiMoney,
        val receipt: ApiRideResponse.Receipt?,
    ) {
        @Serializable
        public enum class State {
            @SerialName(value = "not_initiated")
            NOT_INITIATED,

            @SerialName(value = "pending")
            PENDING,

            @SerialName(value = "action_required")
            ACTION_REQUIRED,

            @SerialName(value = "cancellation_pending")
            CANCELLATION_PENDING,

            @SerialName(value = "reserved")
            RESERVED,

            @SerialName(value = "failed")
            FAILED,

            @SerialName(value = "cancelled")
            CANCELLED,

            @SerialName(value = "succeeded")
            SUCCEEDED,

            UNSUPPORTED,
        }

        @SerialName(value = "charge_type")
        public enum class ChargeType {
            @SerialName(value = "payment")
            PAYMENT,

            @SerialName(value = "refund")
            REFUND,

            UNSUPPORTED,
        }
    }

    @Serializable
    public data class Invoice(
        val id: String?,
        @SerialName(value = "user_id") val userId: String,
        @SerialName(value = "purchase_id") val purchaseId: String,
        @SerialName(value = "attachment_url") val attachmentUrl: String?,
        @SerialName(value = "created_at") val createdAt: Instant?,
        @SerialName(value = "updated_at") val updatedAt: Instant?,
    )

    @Serializable
    public enum class CreatorType {
        @SerialName(value = "User")
        USER,

        @SerialName(value = "Admin")
        ADMIN,

        @SerialName(value = "Platform")
        PLATFORM,

        UNSUPPORTED,
    }
}
