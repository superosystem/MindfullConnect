package dev.gusriil.mindfullconnect.android.dto.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserRegistrationModel(
    val email: String,
    val username: String,
    val password: String
) : Parcelable