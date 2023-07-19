package dev.gusriil.mindfullconnect.android.repository.auth

import dev.gusriil.mindfullconnect.android.dto.user.UserCredModel
import dev.gusriil.mindfullconnect.android.dto.user.UserLoginModel
import dev.gusriil.mindfullconnect.android.dto.user.UserRegistrationModel
import dev.gusriil.mindfullconnect.android.utils.Result

interface AuthRepository {
    suspend fun login(loginModel: UserLoginModel): Result<UserCredModel?>

    suspend fun registration(registrationModel: UserRegistrationModel): Result<UserCredModel?>

    sealed class Endpoints(val url: String) {
        object LOGIN : Endpoints("/login")
        object REGISTRATION : Endpoints("/register")
    }
}