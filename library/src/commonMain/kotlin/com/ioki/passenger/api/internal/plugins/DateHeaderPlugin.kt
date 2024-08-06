package com.ioki.passenger.api.internal.plugins

import com.ioki.passenger.api.TimeOffsetProvider
import com.ioki.passenger.api.internal.utils.parseRfc1123DateTime
import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.http.HttpHeaders

internal val DateHeaderPlugin: ClientPlugin<DateHeaderConfig> =
    createClientPlugin("DateHeaderPlugin", ::DateHeaderConfig) {
        onResponse { response ->
            response.headers[HttpHeaders.Date]?.let { dateString ->
                val localDateTime = parseRfc1123DateTime(dateString)
                this@createClientPlugin.pluginConfig.offsetProvider?.setReferenceTime(localDateTime)
            }
        }
    }

public class DateHeaderConfig {
    public var offsetProvider: TimeOffsetProvider? = null
}
