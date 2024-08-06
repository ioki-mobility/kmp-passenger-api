package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiVehicle(
    @SerialName(value = "license_plate")
    val licensePlate: String,
    val nickname: String,
    val manufacturer: String,
    val model: String,
    @SerialName(value = "fuel_type")
    val fuelType: String,
    @SerialName(value = "operator_information")
    val operatorInfo: String?,
    val avatar: ApiAvatar?,
    val seats: Int,
    @SerialName(value = "storage_spaces") val storageSpaces: Int,
    val autonomous: Boolean,
)
