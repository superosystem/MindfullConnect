package dev.gusriil.mindfullconnect.backend.routing

import dev.gusriil.mindfullconnect.backend.common.filter.handleSearchFilters
import dev.gusriil.mindfullconnect.backend.common.paging.handlePagination
import dev.gusriil.mindfullconnect.backend.common.security.UserInfo
import dev.gusriil.mindfullconnect.backend.controller.PostController
import dev.gusriil.mindfullconnect.backend.dtos.post.CreateEditPostModel
import dev.gusriil.mindfullconnect.backend.plugins.PostEditException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.postRoutes(postController: PostController) {

    authenticate {
        route("/post") {
            post {
                val post = call.receive<CreateEditPostModel>()
                call.respond(HttpStatusCode.OK, postController.createPost(UserInfo.getId(call.principal()), post))
            }

            put {
                val post = call.receive<CreateEditPostModel>()
                postController.editPost(UserInfo.getId(call.principal()), post)
                call.respond(HttpStatusCode.OK, true)
            }

            delete("/{postId}") {
                call.parameters["postId"]?.let {
                    postController.removePost(UserInfo.getId(call.principal()), it.toLong())
                } ?: throw PostEditException()
                call.respond(HttpStatusCode.OK, true)
            }
        }

        route("/post/{postId}/like") {
            post {
                call.parameters["postId"]?.let {
                    postController.addLike(UserInfo.getId(call.principal()), it.toLong())
                } ?: throw PostEditException()
                call.respond(HttpStatusCode.OK, true)
            }
            delete {
                call.parameters["postId"]?.let {
                    postController.removeLike(UserInfo.getId(call.principal()), it.toLong())
                } ?: throw PostEditException()
                call.respond(HttpStatusCode.OK, true)
            }
        }

        get("/my_posts") {
            val queryParams = call.request.queryParameters
            call.respond(
                HttpStatusCode.OK,
                postController.selectUserPosts(
                    UserInfo.getId(call.principal()),
                    handlePagination(queryParams),
                    handleSearchFilters(queryParams)
                )
            )
        }
        get("/my_favourite_posts") {
            val queryParams = call.request.queryParameters
            call.respond(
                HttpStatusCode.OK,
                postController.selectUserFavouritePosts(
                    UserInfo.getId(call.principal()),
                    handlePagination(queryParams),
                    handleSearchFilters(queryParams)
                )
            )
        }
        get("/feed_posts") {
            val queryParams = call.request.queryParameters
            call.respond(
                HttpStatusCode.OK,
                postController.selectFeedPosts(
                    UserInfo.getId(call.principal()),
                    handlePagination(queryParams),
                    handleSearchFilters(queryParams)
                )
            )
        }
        get("/popular_posts") {
            val queryParams = call.request.queryParameters
            call.respond(
                HttpStatusCode.OK,
                postController.selectPopularPosts(
                    UserInfo.getId(call.principal()),
                    handlePagination(queryParams),
                    handleSearchFilters(queryParams)
                )
            )
        }
    }
}