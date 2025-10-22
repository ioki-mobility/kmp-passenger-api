package com.ioki.passenger.api.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideSeriesRequest(@SerialName(value = "additional_dates") val additionalDates: List<LocalDate>)
