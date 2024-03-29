package dev.gusriil.mindfullconnect.android.dto.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserPostModel(
    val userId: Long?,
    val username: String?,
    val avatarUrl: String?
) : Parcelable