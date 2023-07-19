package dev.gusriil.mindfullconnect.backend.infrastructure.post

import dev.gusriil.mindfullconnect.backend.common.filter.SearchFilter
import dev.gusriil.mindfullconnect.backend.common.paging.Pagination
import dev.gusriil.mindfullconnect.backend.common.paging.PaginationResult
import dev.gusriil.mindfullconnect.backend.dtos.post.CreateEditPostModel
import dev.gusriil.mindfullconnect.backend.dtos.post.PostModel

interface PostRepository {
    fun editPost(userId: Long, post: CreateEditPostModel)

    fun createPost(userId: Long, post: CreateEditPostModel): Long

    fun removePost(userId: Long, postId: Long)

    fun selectUserPosts(
        userId: Long,
        pagination: Pagination,
        search: SearchFilter?
    ): PaginationResult<PostModel>

    fun selectUserFavouritePosts(
        userId: Long,
        pagination: Pagination,
        search: SearchFilter?
    ): PaginationResult<PostModel>

    fun selectFeedPosts(
        userId: Long,
        pagination: Pagination,
        search: SearchFilter?
    ): PaginationResult<PostModel>

    fun selectPopularPosts(
        userId: Long,
        pagination: Pagination,
        search: SearchFilter?
    ): PaginationResult<PostModel>

    fun incrementLikeCounter(postId: Long)

    fun decrementLikeCounter(postId: Long)
}