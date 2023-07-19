package dev.gusriil.mindfullconnect.android.network

abstract class ApiBuilder {
    companion object {
        const val AUTHORIZATION = "Authorization"
        private const val BEARER = "Bearer"
        fun authToken(token: String?) = "$BEARER $token"
    }
}