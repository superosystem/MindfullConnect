package dev.gusriil.mindfullconnect.android.repository.auth

import dev.gusriil.mindfullconnect.android.dto.user.UserCredModel
import dev.gusriil.mindfullconnect.android.dto.user.UserLoginModel
import dev.gusriil.mindfullconnect.android.dto.user.UserRegistrationModel
import dev.gusriil.mindfullconnect.android.network.FormattedNetworkClientException
import dev.gusriil.mindfullconnect.android.network.RestApiBuilder
import dev.gusriil.mindfullconnect.android.utils.Result
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthRepositoryImpl(private val client: RestApiBuilder) : AuthRepository {
    override suspend fun login(loginModel: UserLoginModel): Result<UserCredModel?> {
        return try {
            Result.Success(client.api.post(AuthRepository.Endpoints.LOGIN.url) {
                contentType(ContentType.Application.Json)
                setBody(loginModel)
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun registration(registrationModel: UserRegistrationModel): Result<UserCredModel?> {
        return try {
            Result.Success(client.api.post(AuthRepository.Endpoints.REGISTRATION.url) {
                contentType(ContentType.Application.Json)
                setBody(registrationModel)
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }
}