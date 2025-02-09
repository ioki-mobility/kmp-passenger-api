package com.ioki.passenger.api.test

import com.ioki.passenger.api.RideService
import com.ioki.passenger.api.models.ApiBookingRequest
import com.ioki.passenger.api.models.ApiCancellationRequest
import com.ioki.passenger.api.models.ApiCancellationVoucherRequest
import com.ioki.passenger.api.models.ApiCancellationVoucherResponse
import com.ioki.passenger.api.models.ApiDoorStateChangeRequest
import com.ioki.passenger.api.models.ApiRatingRequest
import com.ioki.passenger.api.models.ApiRatingResponse
import com.ioki.passenger.api.models.ApiRideFilterType
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import com.ioki.passenger.api.models.ApiRideInquiryResponse
import com.ioki.passenger.api.models.ApiRideRequest
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.result.ApiResult

public open class RideServiceFake : RideService {
    override suspend fun createRide(request: ApiRideRequest): ApiResult<ApiRideResponse> = error("Not overridden")

    override suspend fun createBooking(rideId: String, request: ApiBookingRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun cancelRide(
        rideId: String,
        cancellationRequest: ApiCancellationRequest,
    ): ApiResult<ApiRideResponse> = error("Not overridden")

    override suspend fun changeDoorState(rideId: String, request: ApiDoorStateChangeRequest): ApiResult<Unit> =
        error("Not overridden")

    override suspend fun getCancellationVoucher(
        rideId: String,
        request: ApiCancellationVoucherRequest,
    ): ApiResult<ApiCancellationVoucherResponse> = error("Not overridden")

    override suspend fun getRide(rideId: String): ApiResult<ApiRideResponse> = error("Not overridden")

    override suspend fun getRides(type: ApiRideFilterType, page: Int): ApiResult<List<ApiRideResponse>> =
        error("Not overridden")

    override suspend fun submitRating(rideId: String, request: ApiRatingRequest): ApiResult<ApiRatingResponse> =
        error("Not overridden")

    override suspend fun inquireRide(request: ApiRideInquiryRequest): ApiResult<ApiRideInquiryResponse> =
        error("Not overridden")
}
