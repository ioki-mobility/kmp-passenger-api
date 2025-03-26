package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiFareResponse
import com.ioki.passenger.api.test.models.createApiLocation
import com.ioki.passenger.api.test.models.createApiVehicle
import kotlinx.datetime.Instant
import kotlin.test.Test

internal class ApiRideResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiRideResponse(
                id = "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
                productId = "product-id",
                state = ApiBookingState.SEARCHING,
                version = 1,
                passengers = listOf(
                    ApiRideResponse.PassengerSelection(
                        type = "adult",
                        options = listOf(
                            ApiOption(slug = "wheelchair", value = AnyValue.BooleanValue(false)),
                            ApiOption(slug = "bahncard", value = AnyValue.BooleanValue(false)),
                            ApiOption(slug = "walker", value = AnyValue.BooleanValue(true)),
                            ApiOption(
                                slug = "public_transport_ticket",
                                value = AnyValue.BooleanValue(true),
                            ),
                            ApiOption(slug = "blue_badge", value = AnyValue.BooleanValue(true)),
                        ),
                        firstName = null,
                        lastName = null,
                    ),
                    ApiRideResponse.PassengerSelection(
                        type = "child",
                        options = listOf(
                            ApiOption(slug = "wheelchair", value = AnyValue.BooleanValue(true)),
                            ApiOption(slug = "bahncard", value = AnyValue.BooleanValue(true)),
                            ApiOption(slug = "walker", value = AnyValue.BooleanValue(false)),
                            ApiOption(
                                slug = "public_transport_ticket",
                                value = AnyValue.BooleanValue(false),
                            ),
                            ApiOption(slug = "blue_badge", value = AnyValue.BooleanValue(true)),
                        ),
                        firstName = "Super",
                        lastName = "Man",
                    ),
                ),
                options = listOf(
                    ApiOption(slug = "storage_spaces", value = AnyValue.IntValue(1)),
                    ApiOption(slug = "stuff", value = AnyValue.BooleanValue(true)),
                    ApiOption(slug = "another_one", value = AnyValue.StringValue("true")),
                ),
                cancellationReason = ApiCancellationReason.NO_VEHICLE_AVAILABLE,
                cancellationReasonTranslated = "reason",
                vehicleApproachedPickup = true,
                vehicleReachedPickup = true,
                vehicleReachedDropoff = true,
                validForPassengerUntil = Instant.parse("2017-05-15T12:23:41Z"),
                rateable = true,
                rideSeriesId = "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
                tippable = true,
                cancellable = false,
                needsCancellationCode = true,
                prebooked = true,
                origin = createApiLocation(lat = 50.104692, lng = 8.644062, locationName = "Galluswarte"),
                destination = createApiLocation(lat = 50.113695, lng = 8.678996, locationName = "Hauptwache"),
                pickup = createApiLocation(
                    lat = 50.116792,
                    lng = 8.671273,
                    locationName = "Station neben \"der Welle\"",
                ),
                dropoff = createApiLocation(lat = 50.10953, lng = 8.668499, locationName = "Silver Tower"),
                vehicle = createApiVehicle(
                    licensePlate = "AB CD 123",
                    nickname = "Bob the Vehicle 2",
                    manufacturer = "Mercedes Benz",
                    model = "V-Klasse",
                    fuelType = "Diesel",
                    operatorInfo = "Operated by Ioki",
                    avatar = null,
                    seats = 5,
                    storageSpaces = 3,
                    autonomous = false,
                ),
                driver = ApiDriver(
                    connectedVehicleId = "veh_9948bf20-7984-44ce-85f1-3610daa8db3d",
                    displayName = "John Doe",
                ),
                fare = createApiFareResponse(
                    bookingPriceType = ApiFareResponse.BookingPriceType.FIXED,
                    id = "far_123",
                    bookingPrice = ApiMoney(amount = 1000, currency = "EUR"),
                ),
                booking = ApiBooking(verificationCode = "ABC123"),
                rating = ApiRatingResponse(
                    id = "abc123",
                    ratingLineItems = listOf(
                        ApiRatingLineItem(criterionSlug = "driver", value = 5),
                        ApiRatingLineItem(criterionSlug = "ride", value = 4),
                    ),
                    comment = "Nice comment",
                ),
                paymentMethod = ApiPaymentMethodResponse(
                    paymentMethodType = ApiPaymentMethodType.STRIPE,
                    id = null,
                    summary = null,
                ),
                driverCanBeCalled = true,
                publicTransportUri = "",
                createdAt = Instant.parse("2017-05-15T12:23:41Z"),
                ticket = ApiRideResponse.Ticket(
                    host = "https://ioki.com",
                    mobileTicketData = listOf(
                        ApiRideResponse.Ticket.MobileTicketData(
                            purchaseId = "IOKI",
                            customerCode = "CUST123",
                        ),
                    ),
                    ticketUrl = "https://ioki.com",
                ),
                receipts = listOf(
                    ApiRideResponse.Receipt(
                        type = ApiRideResponse.Receipt.Type.PERSONAL_DISCOUNT,
                        url = "https://receipt.com",
                    ),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.RIDE, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.RIDE_PAYMENT_RECOVERY, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.SERVICE_CREDIT, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.TIP, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.RIDE_REFUND, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.BOOKING_REFUND, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.BOOKING, null),
                    ApiRideResponse.Receipt(ApiRideResponse.Receipt.Type.UNSUPPORTED, null),
                ),
                route = null,
                tip = null,
                supportUri = "https://ioki.com/en/ioki-devs",
                offeredSolutions = listOf(
                    ApiOfferedSolution(
                        type = "offered_solution",
                        id = "pcm_fffb2f8f-2aa9-4893-9eed-504e25112563",
                        bookable = true,
                        fare = createApiFareResponse(
                            bookingPriceType = ApiFareResponse.BookingPriceType.FIXED,
                            id = "far_123",
                            bookingPrice = ApiMoney(1000, "EUR"),
                        ),
                        hops = listOf(
                            ApiOfferedSolution.Hop(
                                transportMode = ApiOfferedSolution.Hop.TransportMode.DRT,
                                duration = 600,
                                track = "_khkH_q`q@_ry@_ry@",
                                vehicle = ApiVehicle(
                                    licensePlate = "AB CD 123",
                                    nickname = "Bob the Vehicle 2",
                                    manufacturer = "Mercedes Benz",
                                    model = "V-Klasse",
                                    fuelType = "Diesel",
                                    operatorInfo = "Operated by Ioki",
                                    avatar = null,
                                    seats = 5,
                                    storageSpaces = 3,
                                    autonomous = false,
                                    supportsOpenDoorRequests = false,
                                    doorControlAvailable = false,
                                ),
                                from = createApiLocation(
                                    lat = 51.34341,
                                    lng = 12.34252,
                                ),
                                to = createApiLocation(
                                    lat = 51.32094,
                                    lng = 12.3734,
                                ),
                                details = null,
                            ),
                        ),
                    ),
                ),
                bookedSolution = ApiOfferedSolution(
                    type = "booked_solution",
                    id = "pcm_fffb2f8f-2aa9-4893-9eed-504e25112563",
                    bookable = true,
                    fare = createApiFareResponse(
                        bookingPriceType = ApiFareResponse.BookingPriceType.FIXED,
                        id = "far_123",
                        bookingPrice = ApiMoney(1000, "EUR"),
                    ),
                    hops = listOf(
                        ApiOfferedSolution.Hop(
                            transportMode = ApiOfferedSolution.Hop.TransportMode.DRT,
                            duration = 600,
                            track = "_khkH_q`q@_ry@_ry@",
                            vehicle = ApiVehicle(
                                licensePlate = "AB CD 123",
                                nickname = "Bob the Vehicle 2",
                                manufacturer = "Mercedes Benz",
                                model = "V-Klasse",
                                fuelType = "Diesel",
                                operatorInfo = "Operated by Ioki",
                                avatar = null,
                                seats = 5,
                                storageSpaces = 3,
                                autonomous = false,
                                supportsOpenDoorRequests = false,
                                doorControlAvailable = false,
                            ),
                            from = createApiLocation(
                                lat = 51.34341,
                                lng = 12.34252,
                            ),
                            to = createApiLocation(
                                lat = 51.32094,
                                lng = 12.3734,
                            ),
                            details = null,
                        ),
                    ),
                ),
                passengerNoteToDriver = "This is a note to the driver",
            ),
            jsonString = rideResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiRideResponse(
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
                origin = createApiLocation(lat = 50.104692, lng = 8.644062, locationName = "Galluswarte"),
                destination = createApiLocation(lat = 50.113695, lng = 8.678996, locationName = "Hauptwache"),
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
                receipts = emptyList(),
                driver = null,
                fare = null,
                tip = null,
                supportUri = null,
                offeredSolutions = listOf(),
                options = emptyList(),
                bookedSolution = null,
                passengerNoteToDriver = "",
            ),
            jsonString = rideResponseMinimal,
        )
    }
}

private val rideResponse =
    """
{
  "id": "rid_c7394eb7-2af1-4d0c-9e8e-56c2c69f0495",
  "product_id": "product-id",
  "version": 1,
  "created_at":"2017-05-15T12:23:41Z",
  "cancellation_reason": "no_vehicle_available",
  "cancellation_reason_translated": "reason",
  "state": "searching",
  "passengers": [
      {
        "type": "adult",
        "options": [
          {
            "slug": "wheelchair",
            "value": false
          },
          {
            "slug": "bahncard",
            "value": false
          },
          {
            "slug": "walker",
            "value": true
          },
          {
            "slug": "public_transport_ticket",
            "value": true
          },
          {
            "slug": "blue_badge",
            "value": true
          }
        ]
      },
      {
        "type": "child",
        "first_name": "Super",
        "last_name": "Man",
        "options": [
          {
            "slug": "wheelchair",
            "value": true
          },
          {
            "slug": "bahncard",
            "value": true
          },
          {
            "slug": "walker",
            "value": false
          },
          {
            "slug": "public_transport_ticket",
            "value": false
          },
          {
            "slug": "blue_badge",
            "value": true
          }
        ]
      }
  ],
  "options": [
    {
      "slug": "storage_spaces",
      "value": 1
    },
    {
      "slug": "stuff",
      "value": true
    },

    {
      "slug": "another_one",
      "value": "true"
    }
  ],
  "vehicle_approached_pickup": true,
  "vehicle_reached_pickup": true,
  "vehicle_reached_dropoff": true,
  "valid_for_passenger_until": "2017-05-15T12:23:41Z",
  "rateable": true,
  "ride_series_id": "ris_d3cf174f-7fc3-49fa-9403-f9ba4b9aa9ce",
  "tippable": true,
  "cancellable": false,
  "needs_cancellation_code": true,
  "prebooked": true,
  "driver_can_be_called": true,
  "public_transport_uri": "",
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
  "pickup": {
    "lat": 50.116792,
    "lng": 8.671273,
    "location_name": "Station neben \"der Welle\"",
    "display_times": []
  },
  "dropoff": {
    "lat": 50.10953,
    "lng": 8.668499,
    "location_name": "Silver Tower",
    "display_times": []
  },
  "vehicle": {
    "license_plate": "AB CD 123",
    "nickname": "Bob the Vehicle 2",
    "manufacturer": "Mercedes Benz",
    "model": "V-Klasse",
    "fuel_type":"Diesel",
    "operator_information":"Operated by Ioki",
    "seats": 5,
    "storage_spaces": 3,
    "autonomous": false,
    "door_control_available": false,
    "supports_open_door_requests": false
  },
  "driver": {
    "display_name": "John Doe",
    "connected_vehicle_id": "veh_9948bf20-7984-44ce-85f1-3610daa8db3d"
  },
  "fare": {
    "id": "far_123",
    "version": 0,
    "booking_price": {
      "amount": 1000,
      "currency": "EUR"
    },
    "booking_price_type": "fixed",
    "show_custom_message": false
  },
  "booking": {
    "verification_code": "ABC123"
  },
  "rating": {
    "id": "abc123",
    "rating_line_items": [
      {
        "criterion_slug": "driver",
        "value": 5
      },
      {
        "criterion_slug": "ride",
        "value": 4
      }
    ],
    "comment": "Nice comment"
  },
  "payment_method": {
    "payment_method_type": "stripe"
  },
  "ticket":{
    "host": "https://ioki.com",
    "mobile_ticket_data": [{
      "purchase_id": "IOKI",
      "customer_code": "CUST123"
    }],
    "ticket_url": "https://ioki.com"
  },
  "receipts": [
    {
      "receipt_type": "PersonalDiscountReceipt",
      "attachment_url": "https://receipt.com"
    },
    {
      "receipt_type": "RideReceipt"
    },
    {
      "receipt_type": "RidePaymentRecoveryReceipt"
    },
    {
      "receipt_type": "ServiceCreditReceipt"
    },
    {
      "receipt_type": "TipReceipt"
    },
    {
      "receipt_type": "RideRefundReceipt"
    },
    {
      "receipt_type": "BookingRefundReceipt"
    },
    {
      "receipt_type": "BookingReceipt"
    },
    {
      "receipt_type" : "Not known"
    }
  ],
  "support_uri": "https://ioki.com/en/ioki-devs",
  "offered_solutions": [
    {
      "id": "pcm_fffb2f8f-2aa9-4893-9eed-504e25112563",
      "type": "offered_solution",
      "bookable": true,
      "fare": {
        "id": "far_123",
        "version": 0,
        "booking_price": {
          "amount": 1000,
          "currency": "EUR"
        },
        "booking_price_type": "fixed",
        "show_custom_message": false
      },
      "hops": [
        {
          "transport_mode": "drt",
          "from": {
            "display_times":[],
            "lat": 51.34341,
            "lng": 12.34252
          },
          "to": {
            "display_times":[],
            "lat": 51.32094,
            "lng": 12.3734
          },
          "track": "_khkH_q`q@_ry@_ry@",
          "duration": 600,
          "vehicle": {
            "license_plate": "AB CD 123",
            "nickname": "Bob the Vehicle 2",
            "manufacturer": "Mercedes Benz",
            "model": "V-Klasse",
            "fuel_type": "Diesel",
            "operator_information": "Operated by Ioki",
            "seats": 5,
            "storage_spaces": 3,
            "autonomous": false,
            "supports_open_door_requests": false,
            "door_control_available": false
          }
        }
      ]
    }
  ],
  "booked_solution": {
      "id": "pcm_fffb2f8f-2aa9-4893-9eed-504e25112563",
      "type": "booked_solution",
      "bookable": true,
      "fare": {
        "id": "far_123",
        "version": 0,
        "booking_price": {
          "amount": 1000,
          "currency": "EUR"
        },
        "booking_price_type": "fixed",
        "show_custom_message": false
      },
      "hops": [
        {
          "transport_mode": "drt",
          "from": {
            "display_times":[],
            "lat": 51.34341,
            "lng": 12.34252
          },
          "to": {
            "display_times":[],
            "lat": 51.32094,
            "lng": 12.3734
          },
          "track": "_khkH_q`q@_ry@_ry@",
          "duration": 600,
          "vehicle": {
            "license_plate": "AB CD 123",
            "nickname": "Bob the Vehicle 2",
            "manufacturer": "Mercedes Benz",
            "model": "V-Klasse",
            "fuel_type": "Diesel",
            "operator_information": "Operated by Ioki",
            "seats": 5,
            "storage_spaces": 3,
            "autonomous": false,
            "supports_open_door_requests": false,
            "door_control_available": false
          }
        }
      ]
    },
    "passenger_note_to_driver": "This is a note to the driver"
}
"""

private val rideResponseMinimal =
    """
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
  "passenger_note_to_driver": ""
}
"""
