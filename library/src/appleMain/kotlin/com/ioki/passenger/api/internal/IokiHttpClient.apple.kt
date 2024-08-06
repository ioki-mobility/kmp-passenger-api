package com.ioki.passenger.api.internal

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

internal actual fun httpClient(): HttpClient = HttpClient(Darwin)
