package dev.gusriil.mindfullconnect.android.network

import dev.gusriil.mindfullconnect.android.data.AccountModule
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class RestApiBuilder(
    private val am: AccountModule
) : ApiBuilder() {

    private val BASE_URL = "https://localhost:8080"
    private val token get() = authToken(am.getToken())

    val api: HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        expectSuccess = true
        install(ContentNegotiation) {
            json()
        }
        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, _ ->
                throw FormattedNetworkClientException(exception.localizedMessage ?: "Unknown Error")
            }
        }
        defaultRequest {
            url(BASE_URL)
            if (token.isNotEmpty()) {
                header(AUTHORIZATION, token)
            }
        }
    }
}