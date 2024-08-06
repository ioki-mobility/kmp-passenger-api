package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiVenueResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiVenueResponse(
                id = "venue-id",
                city = "city",
                county = "county",
                country = "country",
                formattedStreet = "formatted address",
                lat = 50.123,
                lng = 8.123,
                locationName = "location name",
                postalCode = "ABCD123",
                productId = "product-id",
                streetName = "Strasse",
                streetNumber = "123A",
                venueType = ApiVenueResponse.VenueType.OTHER,
            ),
            jsonString = venue,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            model =
            ApiVenueResponse(
                id = "venue-id",
                city = "city",
                county = "county",
                country = "country",
                formattedStreet = "formatted address",
                lat = 50.123,
                lng = 8.123,
                locationName = null,
                postalCode = null,
                productId = "product-id",
                streetName = null,
                streetNumber = null,
                venueType = ApiVenueResponse.VenueType.OTHER,
            ),
            jsonString = venueMinimal,
        )
    }
}

private val venue =
    """
{
                "id": "venue-id",
                "city": "city",
                "county": "county",
                "country": "country",
                "formatted_street": "formatted address",
                "lat": 50.123,
                "lng": 8.123,
                "location_name": "location name",
                "postal_code": "ABCD123",
                "product_id": "product-id",
                "street_name": "Strasse",
                "street_number": "123A",
                "venue_type": "other"
}
"""

private val venueMinimal =
    """
{
                "id": "venue-id",
                "city": "city",
                "county": "county",
                "country": "country",
                "formatted_street": "formatted address",
                "lat": 50.123,
                "lng": 8.123,
                "product_id": "product-id",
                "venue_type": "other"
}
"""
