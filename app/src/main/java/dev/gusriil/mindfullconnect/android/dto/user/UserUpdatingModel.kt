package dev.gusriil.mindfullconnect.android.dto.user

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdatingModel(
    val username: String?,
    val country: String?,
    val city: String?
)