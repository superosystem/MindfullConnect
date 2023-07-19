package dev.gusriil.mindfullconnect.backend.dtos.user

import kotlinx.serialization.Serializable

@Serializable
data class PostMemberModel(val member: Boolean?, val liked: Boolean = false)