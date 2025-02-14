package com.ioki.passenger.api.test

import com.ioki.passenger.api.CurrentRideService
import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiPassengerSelectionRequest
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.result.ApiResult

public open class FakeCurrentRideService : CurrentRideService {
    override suspend fun getCurrentRide(): ApiResult<ApiRideResponse> = error("Not overridden")

    override suspend fun requestPhoneCall(rideId: String): ApiResult<Unit> = error("Not overridden")

    override suspend fun calculateNewFareForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
    ): ApiResult<ApiFareResponse> = error("Not overridden")

    override suspend fun updatePassengersForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
        rideVersion: Int,
        fareVersion: Int,
        paypalSecureElement: String?,
        requirePaymentMethodForPaidChange: Boolean,
    ): ApiResult<ApiRideResponse> = error("Not overridden")
}
