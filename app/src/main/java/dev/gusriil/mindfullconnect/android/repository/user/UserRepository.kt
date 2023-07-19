package dev.gusriil.mindfullconnect.android.repository.user

import dev.gusriil.mindfullconnect.android.dto.user.AvatarModel
import dev.gusriil.mindfullconnect.android.dto.user.UserUpdatingModel
import dev.gusriil.mindfullconnect.android.utils.Result

interface UserRepository {
    suspend fun editUser(userUpdatingModel: UserUpdatingModel): Result<Boolean>

    suspend fun getAvatar(): Result<AvatarModel>

    suspend fun updateAvatar(array: ByteArray): Result<AvatarModel>

    sealed class Endpoints(val url: String) {
        object USER : Endpoints("/user")
        object AVATAR : Endpoints("/avatar")
    }
}