package dev.gusriil.mindfullconnect.android.dto.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class PostMemberModel(var member: Boolean?, var liked: Boolean) : Parcelable