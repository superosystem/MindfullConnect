package dev.gusriil.mindfullconnect.backend.routing

import dev.gusriil.mindfullconnect.backend.common.security.UserInfo
import dev.gusriil.mindfullconnect.backend.controller.UserController
import dev.gusriil.mindfullconnect.backend.dtos.user.UserLoginModel
import dev.gusriil.mindfullconnect.backend.dtos.user.UserRegistrationModel
import dev.gusriil.mindfullconnect.backend.dtos.user.UserUpdatingModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoutes(userController: UserController) {

    post("/register") {
        val userCredentials = call.receive<UserRegistrationModel>()
        call.respond(HttpStatusCode.OK, userController.register(userCredentials))
    }

    post("/login") {
        val userCredentials = call.receive<UserLoginModel>()
        call.respond(HttpStatusCode.OK, userController.login(userCredentials))
    }

    authenticate {
        put("/user") {
            val userUpdatingModel = call.receive<UserUpdatingModel>()
            userController.updateUser(userUpdatingModel, UserInfo.getId(call.principal()))
            call.respond(HttpStatusCode.OK, true)
        }

        route("avatar") {
            post {
                val multipartData = call.receiveMultipart()
                call.respond(
                    HttpStatusCode.OK,
                    userController.uploadAvatar(multipartData, UserInfo.getId(call.principal()))
                )
            }
            get {
                call.respond(
                    HttpStatusCode.OK,
                    userController.getAvatar(UserInfo.getId(call.principal()))
                )
            }
        }
    }
}