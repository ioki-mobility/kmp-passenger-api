package com.ioki.passenger.api.test

import com.ioki.passenger.api.UserService
import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse
import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiRequestTokenResponse
import com.ioki.passenger.api.models.ApiSignUpRequest
import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest
import com.ioki.passenger.api.models.ApiUpdateUserRequest
import com.ioki.passenger.api.models.ApiUserFlagsRequest
import com.ioki.passenger.api.result.ApiResult

public open class FakeUserService : UserService {
    override suspend fun requestApiToken(request: ApiRequestTokenRequest): ApiResult<ApiRequestTokenResponse> =
        error("Not overridden")

    override suspend fun signUp(request: ApiSignUpRequest): ApiResult<ApiAuthenticatedUserResponse> =
        error("Not overridden")

    override suspend fun getUser(): ApiResult<ApiAuthenticatedUserResponse> = error("Not overridden")

    override suspend fun updateUser(request: ApiUpdateUserRequest): ApiResult<ApiAuthenticatedUserResponse> =
        error("Not overridden")

    override suspend fun deleteUser(): ApiResult<Unit> = error("Not overridden")

    override suspend fun logoutUser(): ApiResult<Unit> = error("Not overridden")

    override suspend fun updatePhoneNumber(request: ApiUpdatePhoneNumberRequest): //
        ApiResult<ApiAuthenticatedUserResponse> = error("Not overridden")

    override suspend fun updateUserFlags(request: ApiUserFlagsRequest): ApiResult<ApiAuthenticatedUserResponse> =
        error("Not overridden")

    override suspend fun updateLanguage(): ApiResult<Unit> = error("Not overridden")
}
