package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiRideResponse.PaymentMethodType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Instant

@Serializable
public data class ApiRideResponse(
    override val id: String,
    @SerialName(value = "product_id") val productId: String,
    val state: ApiBookingState = ApiBookingState.UNSUPPORTED,
    override val version: Int,
    val passengers: List<PassengerSelection>,
    @SerialName(value = "options") val options: List<ApiOption>,
    @SerialName(value = "cancellation_reason")
    @Serializable(with = ApiCancellationReasonSerializer::class)
    val cancellationReason: ApiCancellationReason?,
    @SerialName(value = "vehicle_approached_pickup") val vehicleApproachedPickup: Boolean,
    @SerialName(value = "vehicle_reached_pickup") val vehicleReachedPickup: Boolean,
    @SerialName(value = "vehicle_reached_dropoff") val vehicleReachedDropoff: Boolean,
    @SerialName(value = "valid_for_passenger_until") val validForPassengerUntil: Instant?,
    val rateable: Boolean,
    @SerialName(value = "ride_series_id") val rideSeriesId: String?,
    val tippable: Boolean,
    val cancellable: Boolean,
    @SerialName(value = "needs_cancellation_code") val needsCancellationCode: Boolean,
    @SerialName(value = "cancellation_reason_translated") val cancellationReasonTranslated: String?,
    val prebooked: Boolean,
    val origin: ApiLocation,
    val destination: ApiLocation,
    val pickup: ApiLocation?,
    val dropoff: ApiLocation?,
    val vehicle: ApiVehicle?,
    val driver: ApiDriver?,
    val fare: ApiFareResponse?,
    val booking: ApiBooking?,
    val rating: ApiRatingResponse?,
    @SerialName(value = "payment_method") val paymentMethod: ApiPaymentMethodResponse?,
    @SerialName(value = "matching_state") val matchingState: ApiMatchingState?,
    @SerialName(value = "driver_can_be_called") val driverCanBeCalled: Boolean,
    @SerialName(value = "public_transport_uri") val publicTransportUri: String?,
    @SerialName(value = "created_at") val createdAt: Instant,
    val route: Route?,
    val ticket: Ticket?,
    val tip: ApiTipResponse?,
    @SerialName(value = "support_uri") val supportUri: String?,
    @SerialName(value = "offered_solutions") val offeredSolutions: List<ApiOfferedSolution>,
    @SerialName(value = "booked_solution") val bookedSolution: ApiBookedSolution?,
    @SerialName(value = "passenger_note_to_driver") val passengerNoteToDriver: String,
    @SerialName(value = "show_pt_ticket_reminder") val showPublicTransportTicketReminder: Boolean,
    @SerialName(value = "payment_method_required") val paymentMethodRequired: Boolean,
    @SerialName(value = "has_ticketing_vouchers") val hasTicketingVouchers: Boolean,
    @SerialName(value = "available_booking_payment_method_types")
    val availableBookingPaymentMethodTypes: List<PaymentMethodType>?,
    @SerialName(value = "available_tip_payment_method_types")
    val availableTipPaymentMethodTypes: List<PaymentMethodType>?,
) : Entity {
    @Serializable
    public data class PassengerSelection(
        val type: String,
        val options: List<ApiOption>,
        @SerialName(value = "first_name")
        val firstName: String?,
        @SerialName(value = "last_name")
        val lastName: String?,
    )

    @Serializable(with = RideResponsePaymentMethodTypeSerializer::class)
    public enum class PaymentMethodType {
        @SerialName(value = "cash")
        CASH,

        @SerialName(value = "psp_provided")
        PSP_PROVIDED,

        @SerialName(value = "service_credits")
        SERVICE_CREDITS,

        @SerialName(value = "pos_payment")
        POS_PAYMENT,
        UNSUPPORTED,
    }

    @Serializable
    public data class Route(@SerialName(value = "track") val track: String?)

    @Serializable
    public data class Ticket(
        val host: String?,
        @SerialName(value = "mobile_ticket_data") val mobileTicketData: List<MobileTicketData?>?,
        @SerialName(value = "ticket_url") val ticketUrl: String,
        val issuer: String,
    ) {
        @Serializable
        public data class MobileTicketData(
            @SerialName(value = "purchase_id") val purchaseId: String,
            @SerialName(value = "customer_code") val customerCode: String,
        )
    }
}

internal object RideResponsePaymentMethodTypeSerializer : KSerializer<PaymentMethodType> {
    override val descriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): PaymentMethodType = when (decoder.decodeString()) {
        "cash" -> PaymentMethodType.CASH
        "psp_provided" -> PaymentMethodType.PSP_PROVIDED
        "service_credits" -> PaymentMethodType.SERVICE_CREDITS
        "pos_payment" -> PaymentMethodType.POS_PAYMENT
        else -> PaymentMethodType.UNSUPPORTED
    }

    override fun serialize(encoder: Encoder, value: PaymentMethodType) {
        encoder.encodeString(
            when (value) {
                PaymentMethodType.CASH -> "cash"
                PaymentMethodType.PSP_PROVIDED -> "psp_provided"
                PaymentMethodType.SERVICE_CREDITS -> "service_credits"
                PaymentMethodType.POS_PAYMENT -> "pos_payment"
                PaymentMethodType.UNSUPPORTED -> "unsupported"
            },
        )
    }
}
public typealias ApiBookedSolution = ApiOfferedSolution
