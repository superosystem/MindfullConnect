package dev.gusriil.mindfullconnect.backend.dtos.user

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdatingModel(
    val username: String?,
    val country: String?,
    val city: String?
)
