package dev.gusriil.mindfullconnect.android.network

import dev.gusriil.mindfullconnect.android.data.AccountModule
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class WebSocketBuilder(
    private val am: AccountModule
) : ApiBuilder() {

    private val BASE_URL = "https://localhost:8080"

    private val token get() = authToken(am.getToken())

    val socket: HttpClient = HttpClient(CIO) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(BASE_URL)
            if (token.isNotEmpty()) {
                header(AUTHORIZATION, token)
            }
            contentType(ContentType.Application.Json)
        }
        install(WebSockets)
    }
}