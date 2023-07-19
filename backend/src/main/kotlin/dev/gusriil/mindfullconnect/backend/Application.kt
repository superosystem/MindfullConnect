package dev.gusriil.mindfullconnect.backend

import dev.gusriil.mindfullconnect.backend.plugins.configureRouting
import dev.gusriil.mindfullconnect.backend.plugins.configureSecurity
import dev.gusriil.mindfullconnect.backend.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureSecurity()
    configureRouting()
}
