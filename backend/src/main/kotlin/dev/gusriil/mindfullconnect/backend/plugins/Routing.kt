package dev.gusriil.mindfullconnect.backend.plugins

import dev.gusriil.mindfullconnect.backend.controller.ChatController
import dev.gusriil.mindfullconnect.backend.controller.PostController
import dev.gusriil.mindfullconnect.backend.controller.UserController
import dev.gusriil.mindfullconnect.backend.routing.chatSocket
import dev.gusriil.mindfullconnect.backend.routing.postRoutes
import dev.gusriil.mindfullconnect.backend.routing.userRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRoutingPlugin() {
    val userController: UserController by inject()
    val postController: PostController by inject()
    val roomController: ChatController by inject()

    install(Routing) {
        userRoutes(userController)
        postRoutes(postController)
        chatSocket(roomController)
    }
}
