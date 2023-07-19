package dev.gusriil.mindfullconnect.android.dto.message

import android.os.Parcelable
import dev.gusriil.mindfullconnect.android.dto.user.AvatarModel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserMessageModel(
    val id: Long,
    val username: String,
    var avatarModel: AvatarModel?
) : Parcelable