package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiTicketingVoucherResponse(
    val id: String,
    @Serializable(with = ApiTicketingVoucherResponseStateSerializer::class)
    val state: State,
    val price: ApiMoney,
    @SerialName(value = "product")
    val product: ApiTicketingProductResponse?,
    val ticket: Ticket?,
    @SerialName(value = "ride_id") val rideId: String?,
    @SerialName(value = "renewal_information") val renewalInformation: RenewalInformation,
) {
    @Serializable
    public enum class State {
        @SerialName(value = "initiated")
        INITIATED,

        @SerialName(value = "cancelled")
        CANCELLED,

        @SerialName(value = "issued")
        ISSUED,

        @SerialName(value = "redeemed")
        REDEEMED,
        UNSUPPORTED,
    }

    @Serializable
    public data class Ticket(
        val id: String,
        @SerialName(value = "webview_url") val webviewUrl: String?,
        @SerialName(value = "validity_information") val validityInformation: String,
        @SerialName(value = "valid_from") val validFrom: Instant?,
        @SerialName(value = "valid_until") val validUntil: Instant?,
        @SerialName(value = "vendor_ticket_details") val vendorTicketDetails: VendorTicketDetails?,
    ) {
        @Serializable
        public data class VendorTicketDetails(
            @SerialName(value = "customer_code") val customerCode: String,
            @SerialName(value = "full_name") val fullName: String,
            val host: String,
            val issuer: String,
            @SerialName(value = "purchase_id") val purchaseId: String,
        )
    }

    @Serializable
    public data class RenewalInformation(
        val renewable: Boolean,
        @SerialName(value = "valid_from") val validFrom: Instant?,
        @SerialName(value = "valid_until") val validUntil: Instant?,
    )
}

internal object ApiTicketingVoucherResponseStateSerializer : KSerializer<ApiTicketingVoucherResponse.State> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ApiTicketingVoucherResponseState")

    override fun serialize(encoder: Encoder, value: ApiTicketingVoucherResponse.State) {
        when (value) {
            ApiTicketingVoucherResponse.State.INITIATED -> encoder.encodeString("initiated")
            ApiTicketingVoucherResponse.State.CANCELLED -> encoder.encodeString("cancelled")
            ApiTicketingVoucherResponse.State.ISSUED -> encoder.encodeString("issued")
            ApiTicketingVoucherResponse.State.REDEEMED -> encoder.encodeString("redeemed")
            ApiTicketingVoucherResponse.State.UNSUPPORTED -> encoder.encodeString("unsupported")
        }
    }

    override fun deserialize(decoder: Decoder): ApiTicketingVoucherResponse.State {
        val stringValue = decoder.decodeSerializableValue(String.serializer())
        return when (stringValue) {
            "initiated" -> ApiTicketingVoucherResponse.State.INITIATED
            "cancelled" -> ApiTicketingVoucherResponse.State.CANCELLED
            "issued" -> ApiTicketingVoucherResponse.State.ISSUED
            "redeemed" -> ApiTicketingVoucherResponse.State.REDEEMED
            else -> ApiTicketingVoucherResponse.State.UNSUPPORTED
        }
    }
}
