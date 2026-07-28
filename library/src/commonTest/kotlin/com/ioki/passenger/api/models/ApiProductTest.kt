package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiAnnouncement
import com.ioki.passenger.api.test.models.createApiStationResponse
import kotlin.time.Instant
import kotlin.test.Test

internal class ApiProductTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiProduct(
                id = "abc-123",
                version = 1,
                name = "Magic Bus Frankfurt",
                description = "This is such a magic product",
                timezone = ApiTimezone(identifier = "Europe/Berlin"),
                boundingBox = ApiBoundingBox(ApiPoint(1.0, 2.0), ApiPoint(3.0, 4.0)),
                defaultMapBoundingBox = ApiBoundingBox(ApiPoint(0.0, 0.0), ApiPoint(0.0, 0.0)),
                rideOptions = ApiRideOptions(
                    passengers = ApiRideOptions.Passenger(
                        nameRequiredIfNoPublicTransportTicket = true,
                    ),
                    destinationTimeBasedMatching = false,
                    preBookingThreshold = ApiRideOptions.PreBookingThreshold(3600, 604800),
                ),
                announcements =
                listOf(
                    createApiAnnouncement(
                        id = "ann_e1d06443-0ee3-4156-b0b3-c2073bc15c9d",
                        title = "Testing Stackable Announcements",
                        text = "Ignore me!",
                        startsAt = Instant.parse("2023-07-19T13:20:00Z"),
                        endsAt = Instant.parse("2023-08-20T21:59:00Z"),
                        createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                        updatedAt = Instant.parse("2023-07-19T13:17:42Z"),
                        severity = ApiAnnouncement.Severity.INFO,
                        showOnEveryAppStart = true,
                        additionalInformationUrl = "https://ioki.com/impressum/",
                    ),
                    createApiAnnouncement(
                        id = "ann_18fac1f0-4651-481d-9b20-2b70a2aa405d",
                        title = "Heat Warning!",
                        text = "These days excessive temperatures will hit Germany.",
                        startsAt = Instant.parse("2023-07-19T13:20:00Z"),
                        endsAt = Instant.parse("2023-08-20T21:59:00Z"),
                        createdAt = Instant.parse("2023-07-19T13:17:42Z"),
                        updatedAt = Instant.parse("2023-07-19T13:17:42Z"),
                        severity = ApiAnnouncement.Severity.WARNING,
                        showOnEveryAppStart = true,
                        additionalInformationUrl = "https://ioki.com/impressum/",
                    ),
                ),
                prebookable = true,
                adHocBookable = true,
                requiresFixedStation = true,
                fixedStations = listOf(
                    createApiStationResponse(
                        id = "s1",
                        lat = 50.104558,
                        lng = 8.649113,
                        locationName = "station-1",
                    ),
                    createApiStationResponse(
                        id = "s2",
                        lat = 8.649113,
                        lng = 50.104558,
                        locationName = "station-2",
                    ),
                ),
                displayStationsOnMap = true,
                tipping = null,
                rideRatingCriteria = listOf(
                    ApiRideRatingCriteria.RIDE_RATING,
                    ApiRideRatingCriteria.PUNCTUALITY_RATING,
                    ApiRideRatingCriteria.WAITING_TIME_RATING,
                ),
                avatar = null,
                avatarDarkmode = null,
                cancellationStatements = listOf(
                    ApiCancellationStatement(
                        id = "id",
                        title = "other_reason",
                        suitableForRideSeries = true,
                        suitableForSingleRides = true,
                    ),
                ),
                helpUrl = "https://example.com/help.html",
                supportEmail = "support@example.com",
                supportWebsiteUrl = "https://example.com/support_url.html",
                supportPhoneNumber = "+16465550192",
                features = ApiProduct.Features(
                    multipleBookingSolutions = true,
                    serialBooking = true,
                    passengerCancellationStatement = false,
                    prebookingUiAssistance = true,
                    stationSearch = true,
                    updatePassengersAfterBooking = false,
                    venues = true,
                    showAutonomousOnboarding = false,
                    passengerNoteToDriver = true,
                ),
                productRideOptions = listOf(
                    ApiProduct.RideOptions(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "book_for_others",
                        localizedName = "Ride Option 2",
                        optionType = ApiProduct.RideOptions.Type.BOOK_FOR_OTHERS,
                        bookable = false,
                    ),
                    ApiProduct.RideOptions(
                        dataType = ApiProduct.DataType.INTEGER,
                        slug = "storage_spaces",
                        localizedName = "Ride Option 1",
                        optionType = ApiProduct.RideOptions.Type.STORAGE,
                        bookable = true,
                    ),
                ),
                passengerTypes = listOf(
                    ApiProduct.PassengerType(
                        slug = "adult",
                        localizedName = "Passenger Type 1",
                        localizedInfo = "18+",
                        optionType = ApiProduct.PassengerType.Type.ADULT,
                        bookable = true,
                    ),
                ),
                passengerOptions = listOf(
                    ApiProduct.PassengerOption(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "bahncard",
                        localizedName = "Passenger Option 4",
                        localizedInfo = "Passenger Info 4",
                        localizedDescription = "Passenger Desc 4",
                        localizedLink = "Passenger Link 4",
                        localizedLinkText = "Passenger LinkTest 4",
                        optionType = ApiProduct.PassengerOption.Type.BAHNCARD,
                        bookable = true,
                    ),
                    ApiProduct.PassengerOption(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "blue_badge",
                        localizedName = "Passenger Option 5",
                        localizedInfo = null,
                        localizedDescription = null,
                        localizedLink = null,
                        localizedLinkText = null,
                        optionType = ApiProduct.PassengerOption.Type.DOG,
                        bookable = true,
                    ),
                ),
                drtArea = PassengerApiArea(
                    type = "area",
                    id = "area-1",
                    name = "drtArea",
                    slug = "drtArea",
                    areaType = "drt",
                    color = "#ffffff",
                    opacity = 0.5f,
                    strokeWeight = 1,
                    fillColor = "#ffffff",
                    fillOpacity = 0.5f,
                    invert = true,
                    zIndex = 0,
                    legendIndex = 0,
                    legendTitle = "title",
                    legendDescription = "description",
                    area = ApiArea("MultiPolygon", emptyList()),
                ),
                intermodalArea = PassengerApiArea(
                    type = "area",
                    id = "area-2",
                    name = "intermodalArea",
                    slug = "intermodalArea",
                    areaType = "intermodal",
                    color = "#000000",
                    opacity = 0.5f,
                    strokeWeight = 1,
                    fillColor = "#000000",
                    fillOpacity = 0.5f,
                    invert = true,
                    zIndex = 0,
                    legendIndex = 0,
                    legendTitle = "title",
                    legendDescription = "description",
                    area = ApiArea("MultiPolygon", emptyList()),
                ),
            ),
            jsonString = product,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            expectedModel =
            ApiProduct(
                id = "abc-123",
                version = 1,
                name = "Magic Bus Frankfurt",
                timezone = ApiTimezone(identifier = "Europe/Berlin"),
                boundingBox = ApiBoundingBox(ApiPoint(1.0, 2.0), ApiPoint(3.0, 4.0)),
                defaultMapBoundingBox = null,
                rideOptions =
                ApiRideOptions(
                    passengers =
                    ApiRideOptions.Passenger(
                        nameRequiredIfNoPublicTransportTicket = false,
                    ),
                    destinationTimeBasedMatching = false,
                    preBookingThreshold = null,
                ),
                prebookable = false,
                adHocBookable = false,
                displayStationsOnMap = false,
                description = null,
                requiresFixedStation = false,
                fixedStations = emptyList(),
                announcements = emptyList(),
                tipping = null,
                rideRatingCriteria = emptyList(),
                avatar = null,
                avatarDarkmode = null,
                cancellationStatements = null,
                helpUrl = null,
                supportEmail = null,
                supportWebsiteUrl = null,
                supportPhoneNumber = null,
                features =
                ApiProduct.Features(
                    multipleBookingSolutions = true,
                    serialBooking = false,
                    passengerCancellationStatement = false,
                    prebookingUiAssistance = false,
                    stationSearch = false,
                    updatePassengersAfterBooking = false,
                    venues = false,
                    showAutonomousOnboarding = false,
                    passengerNoteToDriver = false,
                ),
                productRideOptions =
                listOf(
                    ApiProduct.RideOptions(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "book_for_others",
                        localizedName = "Ride Option 2",
                        optionType = ApiProduct.RideOptions.Type.DEFAULT,
                        bookable = true,
                    ),
                    ApiProduct.RideOptions(
                        dataType = ApiProduct.DataType.INTEGER,
                        slug = "storage_spaces",
                        localizedName = "Ride Option 1",
                        optionType = ApiProduct.RideOptions.Type.STORAGE,
                        bookable = false,
                    ),
                ),
                passengerTypes =
                listOf(
                    ApiProduct.PassengerType(
                        slug = "adult",
                        localizedName = "Passenger Type 1",
                        localizedInfo = null,
                        optionType = ApiProduct.PassengerType.Type.ADULT,
                        bookable = true,
                    ),
                ),
                passengerOptions =
                listOf(
                    ApiProduct.PassengerOption(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "bahncard",
                        localizedName = "Passenger Option 4",
                        localizedInfo = null,
                        localizedDescription = null,
                        localizedLink = null,
                        localizedLinkText = null,
                        optionType = ApiProduct.PassengerOption.Type.BAHNCARD,
                        bookable = true,
                    ),
                    ApiProduct.PassengerOption(
                        dataType = ApiProduct.DataType.BOOLEAN,
                        slug = "childseat",
                        localizedName = "Passenger Option 5",
                        localizedInfo = null,
                        localizedDescription = null,
                        localizedLink = null,
                        localizedLinkText = null,
                        optionType = ApiProduct.PassengerOption.Type.CHILDSEAT,
                        bookable = false,
                    ),
                ),
                drtArea =
                PassengerApiArea(
                    type = "",
                    id = "",
                    name = "",
                    slug = "",
                    areaType = "",
                    color = "",
                    opacity = 0.5f,
                    strokeWeight = 1,
                    fillColor = "",
                    fillOpacity = 0.5f,
                    invert = false,
                    zIndex = 0,
                    legendIndex = 0,
                    legendTitle = null,
                    legendDescription = null,
                    area = ApiArea("", emptyList()),
                ),
                intermodalArea = null,
            ),
            jsonString = productMinimal,
        )
    }
}

private val productMinimal =
    """
{
  "id": "abc-123",
  "version": 1,
  "name": "Magic Bus Frankfurt",
  "timezone": {
    "identifier": "Europe/Berlin"
  },
  "ride_options": {
    "passengers": {
      "name_required_if_no_public_transport_ticket": false
    },
    "destination_time_based_matching":false
  },
  "announcements": [],
  "prebookable":false,
  "ad_hoc_bookable": false,
  "bounding_box": {
    "min": {
        "lat": 1.0,
        "lng": 2.0
    },
    "max": {
        "lat": 3.0,
        "lng": 4.0
    }
  },
  "requires_fixed_station": false,
  "fixed_stations": [],
  "display_stations_on_map": false,
  "ride_rating_criteria": [],
  "features": {
    "multiple_booking_solutions": true,
    "serial_booking": false,
    "passenger_cancellation_statement": false,
    "prebooking_ui_assistance": false,
    "station_search": false,
    "update_passengers_after_booking": false,
    "venues": false,
    "show_autonomous_onboarding": false,
    "passenger_note_to_driver": false
  },
  "passenger_options": [
    {
      "data_type":"boolean",
      "slug":"bahncard",
      "localized_name":"Passenger Option 4",
      "option_type": "bahncard",
      "bookable": true
    },
    {
      "data_type":"boolean",
      "slug":"childseat",
      "localized_name":"Passenger Option 5",
      "option_type": "childseat",
      "bookable": false
    }
  ],
  "passenger_types":[
    {
      "slug":"adult",
      "localized_name":"Passenger Type 1",
      "option_type": "adult",
      "bookable": true
    }
  ],
  "product_ride_options":[
    {
      "data_type":"boolean",
      "slug":"book_for_others",
      "localized_name":"Ride Option 2",
      "option_type": "default",
      "bookable": true
    },
    {
      "data_type":"integer",
      "slug":"storage_spaces",
      "localized_name":"Ride Option 1",
      "option_type": "storage",
      "bookable": false
    }
  ],
  "drt_area": {
    "type": "",
    "id": "",
    "name": "",
    "slug": "",
    "area_type": "",
    "color": "",
    "opacity": 0.5,
    "stroke_weight": 1,
    "fill_color": "",
    "fill_opacity": 0.5,
    "invert": false,
    "z_index": 0,
    "legend_index": 0,
    "area": {
      "type": "",
      "coordinates": []
    }
  }
}
"""

private val product =
    """
{
  "id": "abc-123",
  "version": 1,
  "name": "Magic Bus Frankfurt",
  "description": "This is such a magic product",
  "timezone": {
    "identifier": "Europe/Berlin"
  },
  "bounding_box": {
    "min": {
        "lat": 1.0,
        "lng": 2.0
    },
    "max": {
        "lat": 3.0,
        "lng": 4.0
    }
  },
  "default_map_bounding_box": {
    "min": {
        "lat": 0.0,
        "lng": 0.0
    },
    "max": {
        "lat": 0.0,
        "lng": 0.0
    }
  },
  "ride_options": {
    "passengers": {
      "name_required_if_no_public_transport_ticket": true
    },
    "destination_time_based_matching":false,
    "prebooking_threshold": {
      "min": 3600,
      "max": 604800
    }
  },
  "announcements": [
      {
          "id": "ann_e1d06443-0ee3-4156-b0b3-c2073bc15c9d",
          "title": "Testing Stackable Announcements",
          "text": "Ignore me!",
          "starts_at": "2023-07-19T13:20:00Z",
          "ends_at": "2023-08-20T21:59:00Z",
          "severity": "info",
          "created_at": "2023-07-19T13:17:42Z",
          "updated_at": "2023-07-19T13:17:42Z",
          "show_on_every_app_start": true,
          "additional_information_url": "https://ioki.com/impressum/"
        },
        {
          "id": "ann_18fac1f0-4651-481d-9b20-2b70a2aa405d",
          "title": "Heat Warning!",
          "text": "These days excessive temperatures will hit Germany.",
          "starts_at": "2023-07-19T13:20:00Z",
          "ends_at": "2023-08-20T21:59:00Z",
          "severity": "warning",
          "created_at": "2023-07-19T13:17:42Z",
          "updated_at": "2023-07-19T13:17:42Z",
          "show_on_every_app_start": true,
          "additional_information_url": "https://ioki.com/impressum/"
        }
  ],
  "prebookable":true,
  "ad_hoc_bookable": true,
  "requires_fixed_station": true,
  "fixed_stations": [
    {
      "id": "s1",
      "lat": 50.104558,
      "lng": 8.649113,
      "location_name": "station-1",
      "visible_on_map": false
    },
    {
      "id": "s2",
      "lat": 8.649113,
      "lng": 50.104558,
      "location_name": "station-2",
      "visible_on_map": false
    }
  ],
  "display_stations_on_map": true,
  "ride_rating_criteria": [
    "ride_rating",
    "punctuality_rating",
    "waiting_time_rating"
  ],
  "cancellation_statements": [
    {
      "id": "id",
      "title": "other_reason",
      "suitable_for_ride_series": true,
      "suitable_for_single_rides": true
    }
  ],
  "features": {
    "multiple_booking_solutions": true,
    "serial_booking": true,
    "passenger_cancellation_statement": false,
    "prebooking_ui_assistance": true,
    "station_search": true,
    "update_passengers_after_booking": false,
    "venues": true,
    "show_autonomous_onboarding": false,
    "passenger_note_to_driver": true
  },
  "help_url": "https://example.com/help.html",
  "support_email": "support@example.com",
  "support_website_url": "https://example.com/support_url.html",
  "support_phone_number": "+16465550192",
  "passenger_options": [
    {
      "data_type":"boolean",
      "slug":"bahncard",
      "localized_name":"Passenger Option 4",
      "localized_info":"Passenger Info 4",
      "localized_description":"Passenger Desc 4",
      "localized_link":"Passenger Link 4",
      "localized_link_text":"Passenger LinkTest 4",
      "option_type": "bahncard",
      "bookable": true
    },
    {
      "data_type":"boolean",
      "slug":"blue_badge",
      "localized_name":"Passenger Option 5",
      "option_type": "dog",
      "bookable": true
    }
  ],
  "passenger_types":[
    {
      "slug":"adult",
      "localized_name":"Passenger Type 1",
      "localized_info":"18+",
      "option_type": "adult",
      "bookable": true
    }
  ],
  "product_ride_options":[
    {
      "data_type":"boolean",
      "slug":"book_for_others",
      "localized_name":"Ride Option 2",
      "option_type": "book_for_others",
      "bookable": false
    },
    {
      "data_type":"integer",
      "slug":"storage_spaces",
      "localized_name":"Ride Option 1",
      "option_type": "storage",
      "bookable": true
    }
  ],
  "drt_area": {
    "type": "area",
    "id": "area-1",
    "name": "drtArea",
    "slug": "drtArea",
    "area_type": "drt",
    "color": "#ffffff",
    "opacity": 0.5,
    "stroke_weight": 1,
    "fill_color": "#ffffff",
    "fill_opacity": 0.5,
    "invert": true,
    "z_index": 0,
    "legend_index": 0,
    "legend_title": "title",
    "legend_description": "description",
    "area": {
      "type": "MultiPolygon",
      "coordinates": []
    }
  },
  "intermodal_area": {
    "type": "area",
    "id": "area-2",
    "name": "intermodalArea",
    "slug": "intermodalArea",
    "area_type": "intermodal",
    "color": "#000000",
    "opacity": 0.5,
    "stroke_weight": 1,
    "fill_color": "#000000",
    "fill_opacity": 0.5,
    "invert": true,
    "z_index": 0,
    "legend_index": 0,
    "legend_title": "title",
    "legend_description": "description",
    "area": {
      "type": "MultiPolygon",
      "coordinates": []
    }
  }
}
"""
