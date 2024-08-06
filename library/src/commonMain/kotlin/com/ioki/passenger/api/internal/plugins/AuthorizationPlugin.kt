package com.ioki.passenger.api.internal.plugins

import com.ioki.passenger.api.internal.authorisation.UNAUTHORIZED
import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.utils.io.errors.IOException

internal val AuthorizationPlugin: ClientPlugin<Unit> = createClientPlugin("AuthorizationPlugin") {
    onRequest { request, _ ->
        request.headers[AUTHORIZATION]?.let { authorization ->
            if (authorization.endsWith(UNAUTHORIZED)) {
                throw AccessTokenUnavailableException(
                    "Authorization header cannot be applied to " +
                        "'${request.url}' because the user is not authenticated. " +
                        "Are you calling authenticated API without user being logged in?",
                )
            }
        }
    }
}

internal class AccessTokenUnavailableException(message: String) : IOException(message)

private const val AUTHORIZATION = "Authorization"
