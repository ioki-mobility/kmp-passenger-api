package com.ioki.passenger.api.result

import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiErrorBody
import kotlinx.serialization.Serializable

@Serializable
public data class SuccessData<out T>(val data: T, val meta: ApiBody.Meta? = null)
@Serializable
public sealed class Error {
    public sealed class Api : Error() {
        public abstract val errors: List<ApiErrorBody.ApiError>
        public abstract val httpStatusCode: Int

        public data class Generic(
            override val errors: List<ApiErrorBody.ApiError>,
            override val httpStatusCode: Int,
        ) : Api()

        public data class Intercepted(
            override val errors: List<ApiErrorBody.ApiError>,
            override val httpStatusCode: Int,
        ) : Api()
    }

    public data class Connectivity(val error: Throwable) : Error()

    public data class Generic(val error: Throwable) : Error()
}
