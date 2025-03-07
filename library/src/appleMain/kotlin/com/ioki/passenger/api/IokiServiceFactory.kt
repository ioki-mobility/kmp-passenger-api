package com.ioki.passenger.api

import com.ioki.passenger.api.internal.Logging

public object IokiServiceFactory {
    public fun create(
        baseUrl: String,
        requestHeaders: RequestHeaders,
        accessTokenProvider: AccessTokenProvider,
        interceptors: Set<ApiErrorInterceptor> = setOf(),
        timeOffsetProvider: TimeOffsetProvider = NoopTimeOffsetProvider,
        logging: Logging? = null,
    ): IokiService = IokiService(
        baseUrl,
        requestHeaders,
        accessTokenProvider,
        interceptors,
        timeOffsetProvider,
        logging,
    )
}
