package com.ioki.passenger.api.result

import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiErrorBody
import com.ioki.result.Result

public typealias ApiResult<T> = Result<SuccessData<T>, Error>

public data class SuccessData<out T>(val value: T, val meta: ApiBody.Meta? = null)

public fun <T> ApiResult(value: T): ApiResult<T> = Result.Success(SuccessData(value))

public val <T> Result.Success<SuccessData<T>>.value: T
    get() = this.data.value

public val <T> Result.Success<SuccessData<T>>.meta: ApiBody.Meta?
    get() = this.data.meta

public sealed class Error {
    public sealed class Api : Error() {
        public abstract val errors: List<ApiErrorBody.ApiError>
        public abstract val httpStatusCode: Int

        public data class Generic(override val errors: List<ApiErrorBody.ApiError>, override val httpStatusCode: Int) :
            Api()

        public data class Intercepted(
            override val errors: List<ApiErrorBody.ApiError>,
            override val httpStatusCode: Int,
        ) : Api()
    }

    public data class Connectivity(val error: Throwable) : Error()

    public data class Generic(val error: Throwable) : Error()
}
