package dev.gusriil.mindfullconnect.backend.infrastructure.user

import dev.gusriil.mindfullconnect.backend.dtos.user.UserUpdatingModel

interface UserRepository {
    fun createUser(username: String, password: String, email: String): Long

    fun getUserByEmail(email: String): User?

    fun updateUser(model: UserUpdatingModel, userId: Long)

    fun getUserById(userId: Long): User?

    fun updateUserAvatar(userId: Long, avatarUrl: String, avatarId: String)
}