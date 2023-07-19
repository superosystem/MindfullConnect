package dev.gusriil.mindfullconnect.backend.controller

import dev.gusriil.mindfullconnect.backend.common.filter.SearchFilter
import dev.gusriil.mindfullconnect.backend.common.paging.Pagination
import dev.gusriil.mindfullconnect.backend.common.paging.PaginationResult
import dev.gusriil.mindfullconnect.backend.dtos.post.CreateEditPostModel
import dev.gusriil.mindfullconnect.backend.dtos.post.PostModel
import dev.gusriil.mindfullconnect.backend.infrastructure.post.PostRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.postlike.PostLikeRepository
import dev.gusriil.mindfullconnect.backend.plugins.PostAlreadyLikedException

class PostController(
    private val postRepo: PostRepository,
    private val postLikeRepo: PostLikeRepository
) {

    fun createPost(userId: Long, post: CreateEditPostModel): CreateEditPostModel {
        val postId = postRepo.createPost(userId, post)
        return post.apply { this.id = postId }
    }

    fun editPost(userId: Long, post: CreateEditPostModel) {
        postRepo.editPost(userId, post)
    }

    fun removePost(userId: Long, postId: Long) {
        postRepo.removePost(userId = userId, postId)
    }

    fun selectUserPosts(userId: Long, pagination: Pagination, search: SearchFilter?): PaginationResult<PostModel> {
        return postRepo.selectUserPosts(userId, pagination, search)
    }

    fun selectFeedPosts(userId: Long, pagination: Pagination, search: SearchFilter?): PaginationResult<PostModel> {
        return postRepo.selectFeedPosts(userId, pagination, search)
    }

    fun selectUserFavouritePosts(
        userId: Long,
        pagination: Pagination,
        search: SearchFilter?
    ): PaginationResult<PostModel> {
        return postRepo.selectUserFavouritePosts(userId, pagination, search)
    }

    fun selectPopularPosts(userId: Long, pagination: Pagination, search: SearchFilter?): PaginationResult<PostModel> {
        return postRepo.selectPopularPosts(userId, pagination, search)
    }

    fun addLike(userId: Long, postId: Long) {
        if (!postLikeRepo.isAlreadyLiked(userId, postId)) {
            postLikeRepo.addLike(userId, postId)
            postRepo.incrementLikeCounter(postId)
        } else throw PostAlreadyLikedException()
    }

    fun removeLike(userId: Long, postId: Long) {
        if (postLikeRepo.isAlreadyLiked(userId, postId)) {
            postLikeRepo.removeLike(userId, postId)
            postRepo.decrementLikeCounter(postId)
        } else throw PostAlreadyLikedException()
    }
}