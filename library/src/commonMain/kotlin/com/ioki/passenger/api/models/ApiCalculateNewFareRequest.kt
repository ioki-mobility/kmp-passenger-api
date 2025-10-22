package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiCalculateNewFareRequest(val passengers: List<ApiPassengerSelectionRequest>)
