package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse.VendorType
import kotlin.test.Test

internal class ApiGeocodingDetailsResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingDetailsResponse(
                lat = 50.113695,
                lng = 8.678996,
                vendorType = VendorType.PLACES,
                locationName = "An der Welle",
                vendor = "ioki",
                vendorId = "vendor_123",
                formattedAddress = "An der Welle 3, Frankfurt am Main, Germany",
                city = "Frankfurt am Main",
                county = "Hessen",
                country = "Germany",
                postalCode = "60322",
                streetName = "An der Welle",
                streetNumber = "3",
            ),
            jsonString = details,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingDetailsResponse(
                lat = 50.113695,
                lng = 8.678996,
                vendor = "ioki",
                vendorId = "vendor_123",
                vendorType = VendorType.PLACES,
                locationName = null,
                formattedAddress = null,
                city = null,
                county = null,
                country = null,
                postalCode = null,
                streetName = null,
                streetNumber = null,
            ),
            jsonString = detailsMinimal,
        )
    }
}

private val details =
    """
{
    "lat": 50.113695,
    "lng": 8.678996,
    "vendor": "ioki",
    "vendor_id": "vendor_123",
    "vendor_type": "places",
    "location_name": "An der Welle",
    "formatted_address": "An der Welle 3, Frankfurt am Main, Germany",
    "city": "Frankfurt am Main",
    "county": "Hessen",
    "country": "Germany",
    "postal_code": "60322",
    "street_name": "An der Welle",
    "street_number": "3"
}
"""

private val detailsMinimal =
    """
{
    "lat": 50.113695,
    "lng": 8.678996,
    "vendor": "ioki",
    "vendor_id": "vendor_123",
    "vendor_type": "places"
}
"""
