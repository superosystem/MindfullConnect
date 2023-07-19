package dev.gusriil.mindfullconnect.backend.common.security

import io.ktor.server.auth.jwt.*

object UserInfo {
    fun getId(principal: JWTPrincipal?): Long {
        return principal?.payload!!.getClaim("id").asLong()
    }
}