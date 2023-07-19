package dev.gusriil.mindfullconnect.android.repository.post

import dev.gusriil.mindfullconnect.android.dto.post.CreateEditPostModel
import dev.gusriil.mindfullconnect.android.dto.post.PostResponseModel
import dev.gusriil.mindfullconnect.android.network.FormattedNetworkClientException
import dev.gusriil.mindfullconnect.android.network.RestApiBuilder
import dev.gusriil.mindfullconnect.android.utils.Result
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class PostRepositoryImpl(private val client: RestApiBuilder) : PostRepository {
    override suspend fun createPost(postModel: CreateEditPostModel): Result<CreateEditPostModel> {
        return try {
            Result.Success(client.api.post(PostRepository.Endpoints.POST.url) {
                contentType(ContentType.Application.Json)
                setBody(postModel)
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun editPost(postModel: CreateEditPostModel): Result<Boolean> {
        return try {
            Result.Success(client.api.put(PostRepository.Endpoints.POST.url) {
                contentType(ContentType.Application.Json)
                setBody(postModel)
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun deletePost(id: Long): Result<Boolean> {
        return try {
            Result.Success(client.api.delete(PostRepository.Endpoints.POST.url + "/$id").body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getMyPosts(): Result<PostResponseModel> {
        return try {
            Result.Success(client.api.get(PostRepository.Endpoints.GET_MY_POSTS.url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getFeedPosts(): Result<PostResponseModel> {
        return try {
            Result.Success(client.api.get(PostRepository.Endpoints.GET_FEED_POSTS.url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getPopularPosts(): Result<PostResponseModel> {
        return try {
            Result.Success(client.api.get(PostRepository.Endpoints.GET_POPULAR_POSTS.url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getFavoritesPosts(): Result<PostResponseModel> {
        return try {
            Result.Success(client.api.get(PostRepository.Endpoints.GET_FAVORITES_POSTS.url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun onLikePost(postId: Long): Result<Boolean> {
        val url = PostRepository.Endpoints.LIKE_DISLIKE.url.replace("{postId}", postId.toString())
        return try {
            Result.Success(client.api.post(url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun onDislikePost(postId: Long): Result<Boolean> {
        val url = PostRepository.Endpoints.LIKE_DISLIKE.url.replace("{postId}", postId.toString())
        return try {
            Result.Success(client.api.delete(url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }
}