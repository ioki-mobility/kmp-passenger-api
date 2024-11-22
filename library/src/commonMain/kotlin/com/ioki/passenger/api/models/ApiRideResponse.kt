package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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
    @SerialName(value = "driver_can_be_called") val driverCanBeCalled: Boolean,
    @SerialName(value = "public_transport_uri") val publicTransportUri: String?,
    @SerialName(value = "created_at") val createdAt: Instant,
    val route: Route?,
    val ticket: Ticket?,
    val tip: ApiTipResponse?,
    val receipts: List<Receipt>,
    @SerialName(value = "support_uri") val supportUri: String?,
    @SerialName(value = "offered_solutions") val offeredSolutions: List<ApiOfferedSolution>,
    @SerialName(value = "booked_solution") val bookedSolution: ApiBookedSolution?,
    @SerialName(value = "passenger_note_to_driver") val passengerNoteToDriver: String,
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

    @Serializable
    public data class Route(
        @SerialName(value = "track") val track: String?,
    )

    @Serializable
    public data class Ticket(
        val host: String?,
        @SerialName(value = "mobile_ticket_data") val mobileTicketData: List<MobileTicketData?>?,
        @SerialName(value = "ticket_url") val ticketUrl: String,
    ) {
        @Serializable
        public data class MobileTicketData(
            @SerialName(value = "purchase_id") val purchaseId: String,
            @SerialName(value = "customer_code") val customerCode: String,
        )
    }

    @Serializable
    public data class Receipt(
        @SerialName(value = "receipt_type") val type: Type = Type.UNSUPPORTED,
        @SerialName(value = "attachment_url") val url: String?,
    ) {
        @Serializable
        public enum class Type {
            @SerialName(value = "PersonalDiscountReceipt")
            PERSONAL_DISCOUNT,

            @SerialName(value = "RideReceipt")
            RIDE,

            @SerialName(value = "BookingReceipt")
            BOOKING,

            @SerialName(value = "RidePaymentRecoveryReceipt")
            RIDE_PAYMENT_RECOVERY,

            @SerialName(value = "ServiceCreditReceipt")
            SERVICE_CREDIT,

            @SerialName(value = "TipReceipt")
            TIP,

            @SerialName(value = "RideRefundReceipt")
            RIDE_REFUND,

            @SerialName(value = "BookingRefundReceipt")
            BOOKING_REFUND,

            UNSUPPORTED,
        }
    }
}

// If a ride has a station or a walkingDuration greater than zero,
// dropoff is different to the destination point.
public val ApiRideResponse.hasDifferentDropoffAndDestinationPoints: Boolean
    get() = dropoff.hasDifferentPoint

public typealias ApiBookedSolution = ApiOfferedSolution

private object ApiCancellationReasonSerializer : KSerializer<ApiCancellationReason?> {
    override val descriptor = String.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: ApiCancellationReason?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }

        encoder.encodeString(
            when (value) {
                ApiCancellationReason.PASSENGER_CANCELLED -> "passenger_cancelled"
                ApiCancellationReason.PASSENGER_CANCELLED_SEARCHING_RIDE -> "passenger_cancelled_searching_ride"
                ApiCancellationReason.PASSENGER_CANCELLED_OFFERED_RIDE -> "passenger_cancelled_offered_ride"
                ApiCancellationReason.PASSENGER_CANCELLED_WAITING_FOR_DRIVER -> "passenger_cancelled_waiting_for_driver"
                ApiCancellationReason.PASSENGER_CANCELLED_AFTER_PICKUP -> "passenger_cancelled_after_pickup"
                ApiCancellationReason.PASSENGER_CANCELLED_BOOKED_RIDE -> "passenger_cancelled_booked_ride"
                ApiCancellationReason.DRIVER_CANCELLED -> "driver_cancelled"
                ApiCancellationReason.DRIVER_REJECTED -> "driver_rejected"
                ApiCancellationReason.NO_VEHICLE_AVAILABLE -> "no_vehicle_available"
                ApiCancellationReason.PASSENGER_DID_NOT_ACCEPT_IN_TIME -> "passenger_did_not_accept_in_time"
                ApiCancellationReason.DRIVER_DID_NOT_ACCEPT_IN_TIME -> "driver_did_not_accept_in_time"
                ApiCancellationReason.RIDE_REQUEST_OUTDATED -> "ride_request_outdated"
                ApiCancellationReason.TRANSACTIONAL_SAVE_FAILED -> "transactional_save_failed"
                ApiCancellationReason.NO_STATIONS_FOUND -> "no_stations_found"
                ApiCancellationReason.APPLY_FAILED -> "apply_failed"
                ApiCancellationReason.NO_TASK_LIST_FOUND -> "no_task_list_found"
                ApiCancellationReason.PROHIBIT_PARALLEL_FILTER -> "prohibit_parallel_filter"
                ApiCancellationReason.UNSUPPORTED -> "UNSUPPORTED"
            },
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): ApiCancellationReason? {
        val stringValue =
            decoder.decodeNullableSerializableValue(String.serializer().nullable) ?: return null

        return when (stringValue) {
            "passenger_cancelled" -> ApiCancellationReason.PASSENGER_CANCELLED
            "passenger_cancelled_searching_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_SEARCHING_RIDE
            "passenger_cancelled_offered_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_OFFERED_RIDE
            "passenger_cancelled_waiting_for_driver" -> ApiCancellationReason.PASSENGER_CANCELLED_WAITING_FOR_DRIVER
            "passenger_cancelled_after_pickup" -> ApiCancellationReason.PASSENGER_CANCELLED_AFTER_PICKUP
            "passenger_cancelled_booked_ride" -> ApiCancellationReason.PASSENGER_CANCELLED_BOOKED_RIDE
            "driver_cancelled" -> ApiCancellationReason.DRIVER_CANCELLED
            "driver_rejected" -> ApiCancellationReason.DRIVER_REJECTED
            "no_vehicle_available" -> ApiCancellationReason.NO_VEHICLE_AVAILABLE
            "passenger_did_not_accept_in_time" -> ApiCancellationReason.PASSENGER_DID_NOT_ACCEPT_IN_TIME
            "driver_did_not_accept_in_time" -> ApiCancellationReason.DRIVER_DID_NOT_ACCEPT_IN_TIME
            "ride_request_outdated" -> ApiCancellationReason.RIDE_REQUEST_OUTDATED
            "transactional_save_failed" -> ApiCancellationReason.TRANSACTIONAL_SAVE_FAILED
            "no_stations_found" -> ApiCancellationReason.NO_STATIONS_FOUND
            "apply_failed" -> ApiCancellationReason.APPLY_FAILED
            "no_task_list_found" -> ApiCancellationReason.NO_TASK_LIST_FOUND
            "prohibit_parallel_filter" -> ApiCancellationReason.PROHIBIT_PARALLEL_FILTER
            else -> ApiCancellationReason.UNSUPPORTED
        }
    }
}
