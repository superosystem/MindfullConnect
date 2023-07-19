package dev.gusriil.mindfullconnect.backend

import dev.gusriil.mindfullconnect.backend.di.mainModule
import dev.gusriil.mindfullconnect.backend.di.postModule
import dev.gusriil.mindfullconnect.backend.di.roomModule
import dev.gusriil.mindfullconnect.backend.di.userModule
import dev.gusriil.mindfullconnect.backend.infrastructure.Environment
import dev.gusriil.mindfullconnect.backend.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

//fun main(args: Array<String>): Unit = EngineMain.main(args)
fun main() {

    val server = embeddedServer(
        Netty,
        port = Environment.SERVER_PORT.toInt(),
        host = "0.0.0.0"
    ) {
        module()
    }

    server.start(wait = true)
}

fun Application.module() {
    install(Koin) {
        modules(mainModule, userModule, postModule, roomModule)
    }

    configureSecurity()
    configureSocketsPlugin()
    configureRoutingPlugin()
    configureSerializationPlugin()
    configureStatusPagesPlugin()
}
