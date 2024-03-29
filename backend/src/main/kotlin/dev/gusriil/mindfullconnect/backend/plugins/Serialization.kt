package dev.gusriil.mindfullconnect.backend.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureSerializationPlugin() {
    install(ContentNegotiation) {
        json()
    }
}
