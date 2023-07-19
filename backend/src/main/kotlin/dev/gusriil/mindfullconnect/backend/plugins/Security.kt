package dev.gusriil.mindfullconnect.backend.plugins

import dev.gusriil.mindfullconnect.backend.common.security.TokenManager
import dev.gusriil.mindfullconnect.backend.infrastructure.Environment
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import org.koin.ktor.ext.inject

fun Application.configureSecurity() {
    val tokenManager: TokenManager by inject()

    authentication {
        jwt {
            val jwtAudience =
                Environment.JWT_AUDIENCE // this@configureSecurity.environment.config.property("jwt.audience").getString()
            realm = Environment.JWT_REALM// this@configureSecurity.environment.config.property("jwt.realm").getString()
            verifier(
                tokenManager.verifyJWTToken()
            )
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }
}