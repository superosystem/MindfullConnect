package dev.gusriil.mindfullconnect.android.data

import dev.gusriil.mindfullconnect.android.dto.user.UserCredModel
import dev.gusriil.mindfullconnect.android.dto.user.UserModel
import dev.gusriil.mindfullconnect.android.dto.user.UserUpdatingModel
import kotlinx.coroutines.flow.Flow

class AccountModule(private val dataStoreManager: DataStoreManager) {
    suspend fun saveUser(user: UserCredModel) {
        dataStoreManager.saveUserToDataStore(
            UserModel(
                user.id,
                user.username,
                user.mail,
                user.country,
                user.city
            )
        )
        user.token?.let { saveToken(it) }
    }

    fun getUser(): Flow<UserModel> {
        return dataStoreManager.getUserFromDataStore()
    }

    suspend fun saveToken(token: String) {
        dataStoreManager.saveUserToken(token)
    }

    fun getToken(): String {
        return dataStoreManager.getUserToken()
    }

    suspend fun updateUser(user: UserUpdatingModel) {
        dataStoreManager.updateUser(user)
    }

    fun getUserId(): Long {
        return dataStoreManager.getUserId()
    }

    suspend fun clearData() {
        dataStoreManager.clearData()
    }
}