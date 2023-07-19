package dev.gusriil.mindfullconnect.backend.dtos.user

import kotlinx.serialization.Serializable

@Serializable
data class UserRegistrationModel(
    val email: String,
    val username: String,
    val password: String
) {
    fun isValidCredentials(): Boolean {
        return username.length >= 3 && password.length >= 5 && email.length >= 10
    }
}
