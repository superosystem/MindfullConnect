package dev.gusriil.mindfullconnect.backend.dtos.post

import dev.gusriil.mindfullconnect.backend.dtos.user.PostMemberModel
import kotlinx.serialization.Serializable

@Serializable
data class PostModel(
    var id: Long? = null,
    val user: UserPostModel,
    val title: String,
    val text: String,
    val visible: Boolean,
    val tag: String?,
    val backColor: String,
    val likes: Long,
    val userStatus: PostMemberModel,
    val createdTime: String?,
    val sign: Int,
    val signColor: String?
)