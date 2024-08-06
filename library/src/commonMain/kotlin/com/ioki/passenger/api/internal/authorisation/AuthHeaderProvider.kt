package com.ioki.passenger.api.internal.authorisation

import com.ioki.passenger.api.AccessTokenProvider

internal fun createAuthHeaderProvider(provider: AccessTokenProvider): AuthHeaderProvider =
    DefaultAuthHeaderProvider(provider)

internal interface AuthHeaderProvider {
    fun provide(): String
}

private class DefaultAuthHeaderProvider(
    private val accessTokenProvider: AccessTokenProvider,
) : AuthHeaderProvider {
    override fun provide(): String = "Bearer ${accessTokenProvider.accessTokenOrUnauthorized}"
}

internal val AccessTokenProvider.accessTokenOrUnauthorized: String
    get() = accessToken ?: UNAUTHORIZED

internal const val UNAUTHORIZED = "<unauthorized>"
