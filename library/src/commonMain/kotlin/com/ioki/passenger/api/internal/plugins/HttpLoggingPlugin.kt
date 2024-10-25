package com.ioki.passenger.api.internal.plugins

import com.ioki.passenger.api.internal.Logging
import io.ktor.client.HttpClient
import io.ktor.client.plugins.api.ClientHook
import io.ktor.client.plugins.api.ClientPlugin
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.plugins.observer.wrapWithContent
import io.ktor.client.statement.HttpReceivePipeline
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.client.utils.EmptyContent
import io.ktor.util.pipeline.PipelineContext
import io.ktor.util.split
import io.ktor.utils.io.InternalAPI
import io.ktor.utils.io.readRemaining
import io.ktor.utils.io.readText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(InternalAPI::class)
internal val HttpLoggingPlugin: ClientPlugin<HttpLoggingConfig> =
    createClientPlugin("HttpLoggingPlugin", ::HttpLoggingConfig) {
        onRequest { request, _ ->
            val logging: Logging? = this@createClientPlugin.pluginConfig.logging
            logging?.invoke("--> ${request.method.value} ${request.url}")
            request.headers.entries().forEach {
                logging?.invoke("${it.key}: ${it.value}")
            }
            if (request.body != EmptyContent) {
                logging?.invoke(request.body.toString())
            }
        }

        on(AfterReceiveHook) { response ->
            val logging: Logging? = this@createClientPlugin.pluginConfig.logging
            logging?.invoke("<-- ${response.status.value} ${response.request.url}")
            response.headers.forEach { key, values ->
                values.forEach { value ->
                    logging?.invoke("$key: $value")
                }
            }
            val (loggingContent, responseContent) = response.rawContent.split(response)
            this@createClientPlugin.pluginConfig.coroutineScope.launch {
                val text = loggingContent.readRemaining().readText()
                if (text.isNotBlank()) logging?.invoke(text)
            }

            proceedWith(response.call.wrapWithContent(responseContent).response)
        }
    }

public class HttpLoggingConfig {
    internal var coroutineScope = CoroutineScope(Dispatchers.Unconfined)
    public var logging: Logging? = null
}

// This was taken from here
// https://github.com/ktorio/ktor/blob/4bbd595bd0172a6af4edb306b4b29424145767ba/ktor-client/ktor-client-core/common/src/io/ktor/client/plugins/observer/ResponseObserver.kt#L47-L87
// To make it possible to read the body of the response twice
private object AfterReceiveHook : ClientHook<suspend AfterReceiveHook.Context.(HttpResponse) -> Unit> {

    class Context(private val context: PipelineContext<HttpResponse, Unit>) {
        suspend fun proceedWith(response: HttpResponse) = context.proceedWith(response)
    }

    override fun install(client: HttpClient, handler: suspend Context.(HttpResponse) -> Unit) {
        client.receivePipeline.intercept(HttpReceivePipeline.After) {
            handler(Context(this), subject)
        }
    }
}
