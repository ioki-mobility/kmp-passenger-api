package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiVehicleTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiVehicle(
                licensePlate = "AB CD 123",
                nickname = "Bob the Vehicle 2",
                manufacturer = "Mercedes Benz",
                model = "V-Klasse",
                fuelType = "Diesel",
                operatorInfo = "Operated by Ioki",
                avatar = ApiAvatar(
                    ApiAvatar.Versions(
                        ApiAvatar.Versions.ImageData(20, 20, "https://some.url/img.png"),
                        ApiAvatar.Versions.ImageData(20, 20, "https://some.url/img.png"),
                        ApiAvatar.Versions.ImageData(20, 20, "https://some.url/img.png"),
                        ApiAvatar.Versions.ImageData(20, 20, "https://some.url/img.png"),
                    ),
                ),
                seats = 5,
                storageSpaces = 3,
                autonomous = false,
                supportsOpenDoorRequests = false,
                doorControlAvailable = false,
            ),
            vehicle,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiVehicle(
                "AB CD 123",
                "Bob the Vehicle 2",
                "Mercedes Benz",
                "V-Klasse",
                "Diesel",
                null,
                null,
                seats = 5,
                storageSpaces = 3,
                autonomous = true,
                supportsOpenDoorRequests = true,
                doorControlAvailable = true,
            ),
            vehicleMinimal,
        )
    }
}

private val vehicle =
    """
{
  "license_plate": "AB CD 123",
  "nickname": "Bob the Vehicle 2",
  "manufacturer": "Mercedes Benz",
  "model": "V-Klasse",
  "fuel_type":"Diesel",
  "operator_information":"Operated by Ioki",
  "avatar": {
    "versions": {
      "large": {
        "height":20,
        "url":"https://some.url/img.png",
        "width":20
        },
      "medium": {
        "height":20,
        "url":"https://some.url/img.png",
        "width":20
        },
      "mini": {
        "height":20,
        "url":"https://some.url/img.png",
        "width":20
        },
      "small": {
        "height":20,
        "url":"https://some.url/img.png",
        "width":20
        }
    }
  },
  "seats": 5,
  "storage_spaces": 3,
  "autonomous": false,
  "supports_open_door_requests": false,
  "door_control_available": false
}
"""

private val vehicleMinimal =
    """
{
  "license_plate": "AB CD 123",
  "nickname": "Bob the Vehicle 2",
  "manufacturer": "Mercedes Benz",
  "model": "V-Klasse",
  "fuel_type":"Diesel",
  "seats": 5,
  "storage_spaces": 3,
  "autonomous": true,
  "supports_open_door_requests": true,
  "door_control_available": true
}
"""
