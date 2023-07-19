package dev.gusriil.mindfullconnect.backend.dtos.user

import kotlinx.serialization.Serializable

@Serializable
data class UserLoginModel(
    val email: String,
    val password: String
)