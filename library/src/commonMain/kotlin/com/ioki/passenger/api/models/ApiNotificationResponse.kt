package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiNotificationResponse.NotificationType
import kotlin.time.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiNotificationResponse(
    val id: String,
    val body: String,
    val channels: List<String>,
    @SerialName(value = "notification_type") val notificationType: NotificationType,
    @SerialName(value = "created_at") val createdAt: Instant,
    @SerialName(value = "updated_at") val updatedAt: Instant?,
    @SerialName(value = "delivered_at") val deliveredAt: Instant?,
) {
    @Serializable(with = ApiNotificationResponseNotificationTypeSerializer::class)
    public enum class NotificationType {
        @SerialName(value = "vehicle_soon_reaches_pickup")
        VEHICLE_SOON_REACHES_PICKUP,

        @SerialName(value = "vehicle_soon_reaches_dropoff")
        VEHICLE_SOON_REACHES_DROP_OFF,

        @SerialName(value = "vehicle_waiting_at_pickup")
        VEHICLE_WAITING_AT_PICKUP,

        @SerialName(value = "vehicle_reached_pickup")
        VEHICLE_REACHED_PICKUP,

        @SerialName(value = "pickup_time_changed")
        PICKUP_TIME_CHANGED,

        @SerialName(value = "driver_completed_dropoff")
        DRIVER_COMPLETED_DROP_OFF,

        @SerialName(value = "driver_cancelled_booked_ride")
        DRIVER_CANCELLED_BOOKED_RIDE,

        @SerialName(value = "driver_cancelled_charge_no_show_fee")
        DRIVER_CANCELLED_CHARGE_NO_SHOW_FEE,

        @SerialName(value = "early_prebooking_reminder")
        EARLY_PREBOOKING_REMINDER,

        @SerialName(value = "late_prebooking_reminder")
        LATE_PREBOOKING_REMINDER,

        @SerialName(value = "passenger_booked")
        PASSENGER_BOOKED,

        @SerialName(value = "passenger_cancelled_booked_ride")
        PASSENGER_CANCELLED_BOOKED_RIDE,

        @SerialName(value = "operator_cancelled_notify_passenger")
        OPERATOR_CANCELLED_NOTIFY_PASSENGER,

        @SerialName(value = "broadcast")
        BROADCAST,

        @SerialName(value = "end_of_pause_reminder")
        END_OF_PAUSE_REMINDER,

        @SerialName(value = "payment_method_detached")
        PAYMENT_METHOD_DETACHED,

        @SerialName(value = "referral_benefit_assigned")
        REFERRAL_BENEFIT_ASSIGNED,

        @SerialName(value = "missing_ticket_reminder")
        MISSING_TICKET_REMINDER,

        @SerialName(value = "pooling_incoming")
        POOLING_INCOMING,

        @SerialName(value = "cancelled_because_of_paypal_reservation_failure")
        CANCELLED_BECAUSE_OF_PAYPAL_RESERVATION_FAILURE,

        @SerialName(value = "cancelled_because_of_failed_logpay_active_customer_check")
        CANCELLED_BECAUSE_OF_FAILED_LOGPAY_ACTIVE_CUSTOMER_CHECK,

        @SerialName(value = "booking_confirmed")
        BOOKING_CONFIRMED,

        @SerialName(value = "booking_confirmed_by_operator")
        BOOKING_CONFIRMED_BY_OPERATOR,

        @SerialName(value = "payment_failed")
        PAYMENT_FAILED,

        @SerialName(value = "renewable_ticketing_voucher")
        RENEWABLE_TICKETING_VOUCHER,

        @SerialName(value = "ride_series_will_expire")
        RIDE_SERIES_WILL_EXPIRE,

        @SerialName(value = "ticket_purchase_failed")
        TICKET_PURCHASE_FAILED,

        @SerialName(value = "user_inactivity_reminder")
        USER_INACTIVITY_REMINDER,

        @SerialName(value = "final_user_inactivity_reminder")
        FINAL_USER_INACTIVITY_REMINDER,

        @SerialName(value = "user_inactivity_discontinued")
        USER_INACTIVITY_DISCONTINUED,
        UNSUPPORTED,
    }
}

internal object ApiNotificationResponseNotificationTypeSerializer : KSerializer<NotificationType> {
    override val descriptor = String.serializer().descriptor
    override fun deserialize(decoder: Decoder): NotificationType = when (decoder.decodeString()) {
        "vehicle_soon_reaches_pickup" -> NotificationType.VEHICLE_SOON_REACHES_PICKUP
        "vehicle_soon_reaches_dropoff" -> NotificationType.VEHICLE_SOON_REACHES_DROP_OFF
        "vehicle_waiting_at_pickup" -> NotificationType.VEHICLE_WAITING_AT_PICKUP
        "vehicle_reached_pickup" -> NotificationType.VEHICLE_REACHED_PICKUP
        "pickup_time_changed" -> NotificationType.PICKUP_TIME_CHANGED
        "driver_completed_dropoff" -> NotificationType.DRIVER_COMPLETED_DROP_OFF
        "driver_cancelled_booked_ride" -> NotificationType.DRIVER_CANCELLED_BOOKED_RIDE
        "driver_cancelled_charge_no_show_fee" -> NotificationType.DRIVER_CANCELLED_CHARGE_NO_SHOW_FEE
        "early_prebooking_reminder" -> NotificationType.EARLY_PREBOOKING_REMINDER
        "late_prebooking_reminder" -> NotificationType.LATE_PREBOOKING_REMINDER
        "passenger_booked" -> NotificationType.PASSENGER_BOOKED
        "passenger_cancelled_booked_ride" -> NotificationType.PASSENGER_CANCELLED_BOOKED_RIDE
        "operator_cancelled_notify_passenger" -> NotificationType.OPERATOR_CANCELLED_NOTIFY_PASSENGER
        "broadcast" -> NotificationType.BROADCAST
        "end_of_pause_reminder" -> NotificationType.END_OF_PAUSE_REMINDER
        "payment_method_detached" -> NotificationType.PAYMENT_METHOD_DETACHED
        "referral_benefit_assigned" -> NotificationType.REFERRAL_BENEFIT_ASSIGNED
        "missing_ticket_reminder" -> NotificationType.MISSING_TICKET_REMINDER
        "pooling_incoming" -> NotificationType.POOLING_INCOMING
        "booking_confirmed" -> NotificationType.BOOKING_CONFIRMED
        "booking_confirmed_by_operator" -> NotificationType.BOOKING_CONFIRMED_BY_OPERATOR
        "payment_failed" -> NotificationType.PAYMENT_FAILED
        "renewable_ticketing_voucher" -> NotificationType.RENEWABLE_TICKETING_VOUCHER
        "ride_series_will_expire" -> NotificationType.RIDE_SERIES_WILL_EXPIRE
        "ticket_purchase_failed" -> NotificationType.TICKET_PURCHASE_FAILED
        "user_inactivity_reminder" -> NotificationType.USER_INACTIVITY_REMINDER
        "final_user_inactivity_reminder" -> NotificationType.FINAL_USER_INACTIVITY_REMINDER
        "user_inactivity_discontinued" -> NotificationType.USER_INACTIVITY_DISCONTINUED
        "cancelled_because_of_paypal_reservation_failure" ->
            NotificationType.CANCELLED_BECAUSE_OF_PAYPAL_RESERVATION_FAILURE
        "cancelled_because_of_failed_logpay_active_customer_check" ->
            NotificationType.CANCELLED_BECAUSE_OF_FAILED_LOGPAY_ACTIVE_CUSTOMER_CHECK
        else -> NotificationType.UNSUPPORTED
    }

    override fun serialize(encoder: Encoder, value: NotificationType) {
        encoder.encodeString(
            when (value) {
                NotificationType.VEHICLE_SOON_REACHES_PICKUP -> "vehicle_soon_reaches_pickup"
                NotificationType.VEHICLE_SOON_REACHES_DROP_OFF -> "vehicle_soon_reaches_dropoff"
                NotificationType.VEHICLE_WAITING_AT_PICKUP -> "vehicle_waiting_at_pickup"
                NotificationType.VEHICLE_REACHED_PICKUP -> "vehicle_reached_pickup"
                NotificationType.PICKUP_TIME_CHANGED -> "pickup_time_changed"
                NotificationType.DRIVER_COMPLETED_DROP_OFF -> "driver_completed_dropoff"
                NotificationType.DRIVER_CANCELLED_BOOKED_RIDE -> "driver_cancelled_booked_ride"
                NotificationType.DRIVER_CANCELLED_CHARGE_NO_SHOW_FEE -> "driver_cancelled_charge_no_show_fee"
                NotificationType.EARLY_PREBOOKING_REMINDER -> "early_prebooking_reminder"
                NotificationType.LATE_PREBOOKING_REMINDER -> "late_prebooking_reminder"
                NotificationType.PASSENGER_BOOKED -> "passenger_booked"
                NotificationType.PASSENGER_CANCELLED_BOOKED_RIDE -> "passenger_cancelled_booked_ride"
                NotificationType.OPERATOR_CANCELLED_NOTIFY_PASSENGER -> "operator_cancelled_notify_passenger"
                NotificationType.BROADCAST -> "broadcast"
                NotificationType.END_OF_PAUSE_REMINDER -> "end_of_pause_reminder"
                NotificationType.PAYMENT_METHOD_DETACHED -> "payment_method_detached"
                NotificationType.REFERRAL_BENEFIT_ASSIGNED -> "referral_benefit_assigned"
                NotificationType.MISSING_TICKET_REMINDER -> "missing_ticket_reminder"
                NotificationType.POOLING_INCOMING -> "pooling_incoming"
                NotificationType.BOOKING_CONFIRMED -> "booking_confirmed"
                NotificationType.BOOKING_CONFIRMED_BY_OPERATOR -> "booking_confirmed_by_operator"
                NotificationType.PAYMENT_FAILED -> "payment_failed"
                NotificationType.RENEWABLE_TICKETING_VOUCHER -> "renewable_ticketing_voucher"
                NotificationType.RIDE_SERIES_WILL_EXPIRE -> "ride_series_will_expire"
                NotificationType.TICKET_PURCHASE_FAILED -> "ticket_purchase_failed"
                NotificationType.USER_INACTIVITY_REMINDER -> "user_inactivity_reminder"
                NotificationType.FINAL_USER_INACTIVITY_REMINDER -> "final_user_inactivity_reminder"
                NotificationType.USER_INACTIVITY_DISCONTINUED -> "user_inactivity_discontinued"
                NotificationType.CANCELLED_BECAUSE_OF_PAYPAL_RESERVATION_FAILURE ->
                    "cancelled_because_of_paypal_reservation_failure"
                NotificationType.CANCELLED_BECAUSE_OF_FAILED_LOGPAY_ACTIVE_CUSTOMER_CHECK ->
                    "cancelled_because_of_failed_logpay_active_customer_check"
                NotificationType.UNSUPPORTED -> "unsupported"
            },
        )
    }
}
