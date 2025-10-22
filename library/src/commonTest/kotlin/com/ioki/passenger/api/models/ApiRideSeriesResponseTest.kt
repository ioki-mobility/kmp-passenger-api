package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiLocation
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlin.test.Test

internal class ApiRideSeriesResponseTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiRideSeriesResponse(
                id = "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
                createdAt = null,
                updatedAt = Instant.parse("2017-05-15T12:23:41Z"),
                baseRideId = "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
                additionalDates = listOf(),
                processingFinishedAt = Instant.parse("2017-05-15T12:23:41Z"),
                rides = listOf(),
                results = listOf(),
            ),
            rideSeriesResponseMinimal,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRideSeriesResponse(
                "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
                Instant.parse("2019-05-15T12:23:41Z"),
                Instant.parse("2017-05-15T12:23:41Z"),
                "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
                listOf(LocalDate.parse("2018-05-15")),
                Instant.parse("2017-05-15T12:23:41Z"),
                listOf(rideResponse),
                listOf(rideSeriesResult),
            ),
            rideSeriesResponse,
        )
    }
}

private val rideSeriesResult =
    ApiRideSeriesResponse.Result(
        processed = true,
        rideDate = LocalDate.parse("2017-05-15"),
        rideId = "id",
        rideCreateSuccess = true,
        rideCreateErrorCode = "Create error",
        bookingSuccess = true,
        bookingErrorCode = "Booking error",
    )

private val rideResponse =
    ApiRideResponse(
        id = "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
        productId = "product-id",
        state = ApiBookingState.SEARCHING,
        version = 1,
        passengers = listOf(),
        cancellationReason = null,
        cancellationReasonTranslated = null,
        vehicleApproachedPickup = true,
        vehicleReachedPickup = true,
        vehicleReachedDropoff = true,
        validForPassengerUntil = null,
        rateable = true,
        rideSeriesId = null,
        tippable = true,
        cancellable = false,
        needsCancellationCode = true,
        prebooked = true,
        origin = createApiLocation(50.104692, 8.644062, "Galluswarte"),
        destination = createApiLocation(50.113695, 8.678996, "Hauptwache"),
        createdAt = Instant.parse("2017-05-15T12:23:41Z"),
        booking = null,
        rating = null,
        pickup = null,
        dropoff = null,
        vehicle = null,
        paymentMethod = null,
        driverCanBeCalled = false,
        publicTransportUri = null,
        route = null,
        ticket = null,
        driver = null,
        fare = null,
        tip = null,
        supportUri = null,
        offeredSolutions = listOf(),
        options = emptyList(),
        bookedSolution = null,
        passengerNoteToDriver = "",
        showPublicTransportTicketReminder = false,
        matchingState = null,
    )

private val rideSeriesResponseMinimal =
    """
{
  "id": "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
  "base_ride_id": "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
  "updated_at": "2017-05-15T12:23:41Z",
  "additional_dates": [],
  "processing_finished_at": "2017-05-15T12:23:41Z",
  "rides": [],
  "results": []
}
"""

private val rideSeriesResponse =
    """
{
  "id": "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
  "base_ride_id": "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
  "created_at": "2019-05-15T12:23:41Z",
  "updated_at": "2017-05-15T12:23:41Z",
  "additional_dates": ["2018-05-15"],
  "processing_finished_at": "2017-05-15T12:23:41Z",
  "rides": [
    {
      "id": "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
      "product_id": "product-id",
      "version": 1,
      "created_at":"2017-05-15T12:23:41Z",
      "state": "searching",
      "passengers": [],
      "vehicle_approached_pickup": true,
      "vehicle_reached_pickup": true,
      "vehicle_reached_dropoff": true,
      "rateable": true,
      "tippable": true,
      "cancellable": false,
      "needs_cancellation_code": true,
      "prebooked": true,
      "driver_can_be_called": false,
      "origin": {
        "location_name": "Galluswarte",
        "lat": 50.104692,
        "lng": 8.644062,
        "display_times": []
      },
      "destination": {
        "location_name": "Hauptwache",
        "lat": 50.113695,
        "lng": 8.678996,
        "display_times": []
      },
      "receipts": [],
      "offered_solutions": [],
      "options": [],
      "passenger_note_to_driver": "",
      "show_pt_ticket_reminder": false
    }
  ],
  "results": [
    {
      "processed": true,
      "ride_date": "2017-05-15",
      "ride_id": "id",
      "ride_create_success": true,
      "ride_create_error_code": "Create error",
      "booking_success": true,
      "booking_error_code": "Booking error"
    }
  ]
}
"""
