package dev.gusriil.mindfullconnect.backend.infrastructure.postlike

interface PostLikeRepository {
    fun isAlreadyLiked(userId: Long, postId: Long): Boolean

    fun addLike(userId: Long, postId: Long)

    fun removeLike(userId: Long, postId: Long)
}