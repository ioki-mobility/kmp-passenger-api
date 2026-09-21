package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

@Serializable
public data class ApiChargeResponse(
    val id: String,
    @SerialName(value = "charge_type") val chargeType: ChargeType,
    @SerialName(value = "user_id") val userId: String,
    @SerialName(value = "payment_charge_id") val paymentChargeId: String?,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodResponse?,
    val reservation: Boolean,
    val state: State,
    val amount: ApiMoney,
    val receipt: Receipt?,
    @SerialName(value = "pending_action") val pendingAction: PendingAction?,
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

    @Serializable
    public data class Receipt(
        val id: String?,
        @SerialName(value = "charge_id") val chargeId: String,
        @SerialName(value = "attachment_url") val attachmentUrl: String?,
        @SerialName(value = "created_at") val createdAt: Instant?,
        @SerialName(value = "updated_at") val updatedAt: Instant?,
    )

    /**
     * The outer `pending_action.type` is always `"charge_challenge"` and carries no useful
     * information, so it's not modeled here. The concrete kind of challenge is instead
     * determined by the nested `pending_action.action.type`.
     */
    @Serializable(with = PendingActionSerializer::class)
    public data class PendingAction(val action: Action) {
        public sealed interface Action {
            @Serializable
            public data class OpenUrl(val url: String) : Action

            public data object Unsupported : Action
        }
    }
}

internal object PendingActionSerializer : KSerializer<ApiChargeResponse.PendingAction> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("PendingAction")

    override fun deserialize(decoder: Decoder): ApiChargeResponse.PendingAction {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonDecoder for ${this::class}")
        val actionJson = input.decodeJsonElement().jsonObject["action"]?.jsonObject
        val action = when (actionJson?.get("type")?.jsonPrimitive?.content) {
            "open_url" -> actionJson.let {
                input.json.decodeFromJsonElement(ApiChargeResponse.PendingAction.Action.OpenUrl.serializer(), it)
            }

            else -> ApiChargeResponse.PendingAction.Action.Unsupported
        }
        return ApiChargeResponse.PendingAction(action = action)
    }

    override fun serialize(encoder: Encoder, value: ApiChargeResponse.PendingAction) {
        val output = encoder as? JsonEncoder ?: throw SerializationException("Expected JsonEncoder for ${this::class}")
        val actionJson = when (val action = value.action) {
            is ApiChargeResponse.PendingAction.Action.OpenUrl ->
                buildJsonObject {
                    put("type", "open_url")
                    put("url", action.url)
                }

            ApiChargeResponse.PendingAction.Action.Unsupported ->
                buildJsonObject { put("type", "unsupported") }
        }
        output.encodeJsonElement(
            buildJsonObject {
                put("type", "charge_challenge")
                put("action", actionJson)
            },
        )
    }
}
