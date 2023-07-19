package dev.gusriil.mindfullconnect.backend.controller

import dev.gusriil.mindfullconnect.backend.common.security.PasswordEncoder.decryptCBC
import dev.gusriil.mindfullconnect.backend.common.security.PasswordEncoder.encryptCBC
import dev.gusriil.mindfullconnect.backend.common.security.TokenManager
import dev.gusriil.mindfullconnect.backend.common.storage.CloudinaryClient
import dev.gusriil.mindfullconnect.backend.dtos.user.*
import dev.gusriil.mindfullconnect.backend.infrastructure.user.UserRepository
import dev.gusriil.mindfullconnect.backend.plugins.LoginException
import dev.gusriil.mindfullconnect.backend.plugins.MultiPartDataNotFoundException
import dev.gusriil.mindfullconnect.backend.plugins.RegistrationFieldLengthException
import dev.gusriil.mindfullconnect.backend.plugins.RegistrationNameException
import io.ktor.http.content.*
import java.io.InputStream
import java.time.LocalDateTime
import java.util.*

class UserController(
    private val userRepo: UserRepository,
    private val tokenManager: TokenManager,
    private val cloudinaryClient: CloudinaryClient
) {

    fun register(model: UserRegistrationModel): UserCredModel {
        val userByUserName = userRepo.getUserByEmail(model.email)
        if (!model.isValidCredentials()) {
            throw RegistrationFieldLengthException()
        }
        if (userByUserName != null) {
            throw RegistrationNameException()
        }

        val userId = userRepo.createUser(model.username, model.password.encryptCBC(), model.email)
        val token = tokenManager.generateJWTToken(UserCredModel(userId, model.email))

        return UserCredModel(userId, model.username, token = token, mail = model.email)
    }

    fun login(model: UserLoginModel): UserCredModel {
        val userByEmail = userRepo.getUserByEmail(model.email)
        if (userByEmail == null || userByEmail.password.decryptCBC() != model.password) {
            throw LoginException()
        }

        val token = tokenManager.generateJWTToken(UserCredModel(userByEmail.id, userByEmail.mail))

        return UserCredModel.fromUserEntity(userByEmail).apply {
            this.token = token
            avatarModel = getAvatar(userByEmail.id)
        }
    }

    fun updateUser(model: UserUpdatingModel, userId: Long) {
        userRepo.updateUser(model, userId)
    }

    suspend fun uploadAvatar(photo: MultiPartData, userId: Long): AvatarModel {
        var resInputStream: InputStream? = null
        var ext: String? = null

        photo.forEachPart { part ->
            when (part) {
                is PartData.FileItem -> {
                    resInputStream = part.streamProvider()
                    ext = part.originalFileName
                }

                else -> {
                    throw MultiPartDataNotFoundException()
                }
            }
        }

        val extension = try {
            "." + ext?.split(".")?.get(1)
        } catch (ext: Exception) {
            ""
        }

        val key = UUID.randomUUID().toString() + System.currentTimeMillis() + extension

        // Use Cloudinary SDK for modify file
        val uploadParams = mapOf("public_id" to key)
        val uploadResult = cloudinaryClient.cloudinary
            .uploader().upload(resInputStream!!, uploadParams)
        val avatarPublicId = uploadResult["public_id"] as String
        val avatarUrl = uploadResult["secure_url"] as String

        userRepo.updateUserAvatar(userId, avatarUrl, avatarPublicId)

        return AvatarModel(avatarUrl)
    }

    fun getAvatar(userId: Long): AvatarModel {
        val userById = userRepo.getUserById(userId)
        userById?.avatarUrl?.let {
            var avatarUrl = userById.avatarUrl
            if (userById.avatarUpdateTime != null && userById.avatarUpdateTime!!.plusDays(6) < LocalDateTime.now()) {
                val avatarPresignedUrl = getAvatarPresignedUrl(userById.avatarId!!)
                userRepo.updateUserAvatar(userId, avatarPresignedUrl, userById.avatarId!!)
                avatarUrl = avatarPresignedUrl
            }
            return AvatarModel(avatarUrl)
        } ?: return AvatarModel(null)
    }

    private fun getAvatarPresignedUrl(keyName: String): String {
        // val expiration = LocalDateTime.now().plusDays(6)

        // Generate the URL directly from cloudinary
        val cloudinaryUrl = cloudinaryClient.cloudinary
            .url().format("jpg").generate(keyName)

        return cloudinaryUrl // This will be the direct URL to access the uploaded image
    }
}