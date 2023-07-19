package dev.gusriil.mindfullconnect.backend.common.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import dev.gusriil.mindfullconnect.backend.dtos.user.UserCredModel
import dev.gusriil.mindfullconnect.backend.infrastructure.Environment
import io.ktor.server.config.*
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class TokenManager() {
    private val expirationDate: LocalDate = LocalDate.now().plusWeeks(2)

    fun generateJWTToken(user: UserCredModel): String {
        return JWT.create()
            .withAudience(Environment.JWT_AUDIENCE)
            .withIssuer(Environment.JWT_ISSUER)
            .withClaim("id", user.id)
            .withClaim("email", user.mail)
            .withExpiresAt(Date.from(expirationDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
            .sign(Algorithm.HMAC256(Environment.JWT_SECRET))
    }

    fun verifyJWTToken(): JWTVerifier {
        return JWT.require(Algorithm.HMAC256(Environment.JWT_SECRET))
            .withAudience(Environment.JWT_AUDIENCE)
            .withIssuer(Environment.JWT_ISSUER)
            .build()
    }
}