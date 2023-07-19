package dev.gusriil.mindfullconnect.backend.infrastructure.message

import dev.gusriil.mindfullconnect.backend.infrastructure.user.User
import dev.gusriil.mindfullconnect.backend.infrastructure.user.Users
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.long
import org.ktorm.schema.varchar
import java.time.LocalDateTime

object Messages : Table<Message>("message") {
    val id = long("id").primaryKey().bindTo { it.id }
    val userId = long("userId").references(Users) { it.user }
    val roomId = long("roomId").bindTo { it.roomId }
    val text = varchar("text").bindTo { it.text }
    val createdTime = datetime("createdTime").bindTo { it.createdTime }
}

interface Message : Entity<Message> {

    companion object : Entity.Factory<Message>()

    val id: Long
    val user: User
    val roomId: Long
    val text: String
    val createdTime: LocalDateTime
}