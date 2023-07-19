package dev.gusriil.mindfullconnect.android.repository.user

import dev.gusriil.mindfullconnect.android.dto.user.AvatarModel
import dev.gusriil.mindfullconnect.android.dto.user.UserUpdatingModel
import dev.gusriil.mindfullconnect.android.network.FormattedNetworkClientException
import dev.gusriil.mindfullconnect.android.network.RestApiBuilder
import dev.gusriil.mindfullconnect.android.utils.Result
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType

class UserRepositoryImpl(private val client: RestApiBuilder) : UserRepository {
    override suspend fun editUser(userUpdatingModel: UserUpdatingModel): Result<Boolean> {
        return try {
            Result.Success(client.api.put(UserRepository.Endpoints.USER.url) {
                contentType(ContentType.Application.Json)
                setBody(userUpdatingModel)
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun getAvatar(): Result<AvatarModel> {
        return try {
            Result.Success(client.api.get(UserRepository.Endpoints.AVATAR.url).body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            Result.Error("Server or network error")
        }
    }

    override suspend fun updateAvatar(array: ByteArray): Result<AvatarModel> {
        return try {
            Result.Success(client.api.post(UserRepository.Endpoints.AVATAR.url) {
                setBody(MultiPartFormDataContent(formData {
                    append("document", array, Headers.build {
                        append(HttpHeaders.ContentType, "images/*") // Mime type required
                        append(HttpHeaders.ContentDisposition, "filename=avatar")
                    })
                }))
            }.body())
        } catch (exception: FormattedNetworkClientException) {
            Result.Error(exception.formattedErrorMessage)
        } catch (exception: Exception) {
            println(exception)
            Result.Error("Server or network error")
        }
    }
}