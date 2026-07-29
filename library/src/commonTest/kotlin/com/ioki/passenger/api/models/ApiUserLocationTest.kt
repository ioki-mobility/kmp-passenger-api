package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUserLocationTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocation(
                id = "user_loc_123",
                version = 1,
                title = "Home",
                locationType = ApiUserLocation.Type.HOME,
                lat = 52.5200,
                lng = 13.4050,
                locationName = "Berlin Central Station",
                streetName = "Europaplatz",
                streetNumber = "1",
                postalCode = "10557",
                city = "Berlin",
                county = "Berlin",
                country = "Germany",
                editableByUser = false,
                userId = "userId",
                customFlags = listOf(ApiUserLocation.CustomFlag(slug = "slug", name = "name")),
            ),
            userLocation,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocation(
                id = "123",
                version = 1,
                title = "Home",
                locationType = ApiUserLocation.Type.HOME,
                lat = 52.520008,
                lng = 13.404954,
                locationName = null,
                streetName = null,
                streetNumber = null,
                postalCode = null,
                city = null,
                county = null,
                country = null,
                editableByUser = false,
                userId = "userId",
                customFlags = listOf(),
            ),
            userLocationMinimal,
        )
    }
}

private val userLocation: String =
    """
        {
            "id": "user_loc_123",
            "version": 1,
            "title": "Home",
            "location_type": "home",
            "lat": 52.5200,
            "lng": 13.4050,
            "location_name": "Berlin Central Station",
            "street_name": "Europaplatz",
            "street_number": "1",
            "postal_code": "10557",
            "city": "Berlin",
            "county": "Berlin",
            "country": "Germany",
            "editable_by_user": "false",
            "user_id": "userId",
            "custom_flags": [{
                "slug": "slug",
                "name": "name"
            }]
        }
    """.trimIndent()
private val userLocationMinimal: String =
    """
        {
            "id": "123",
            "version": 1,
            "title": "Home",
            "location_type": "home",
            "lat": 52.520008,
            "lng": 13.404954,
            "editable_by_user": "false",
            "user_id": "userId",
            "custom_flags": []
        }
    """.trimIndent()
