package dev.gusriil.mindfullconnect.backend.infrastructure.roomuser

import dev.gusriil.mindfullconnect.backend.infrastructure.post.Post
import dev.gusriil.mindfullconnect.backend.infrastructure.post.Posts
import dev.gusriil.mindfullconnect.backend.infrastructure.user.User
import dev.gusriil.mindfullconnect.backend.infrastructure.user.Users
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long

object RoomsToUsers : Table<RoomToUser>("room_user") {
    val id = long("id").primaryKey().bindTo { it.id }
    val userId = long("userId").references(Users) { it.user }
    val roomId = long("roomId").references(Posts) { it.room }
}

interface RoomToUser : Entity<RoomToUser> {

    companion object : Entity.Factory<RoomToUser>()

    val id: Long
    val user: User
    val room: Post
}