package com.ioki.passenger.api.result

import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiErrorBody

public sealed class Result<out T> {
    public abstract fun <R> map(mapper: (T) -> R): Result<R>

    public data class Success<out T>(val data: T, val meta: ApiBody.Meta? = null) : Result<T>() {
        override fun <R> map(mapper: (T) -> R): Success<R> = Success(mapper(data))
    }

    public sealed class Error : Result<Nothing>() {
        override fun <R> map(mapper: (Nothing) -> R): Error = this

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
}
