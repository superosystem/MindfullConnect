package dev.gusriil.mindfullconnect.android.ui.auth.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.gusriil.mindfullconnect.android.data.AccountModule
import dev.gusriil.mindfullconnect.android.dto.user.UserLoginModel
import dev.gusriil.mindfullconnect.android.dto.user.UserRegistrationModel
import dev.gusriil.mindfullconnect.android.repository.auth.AuthRepository
import dev.gusriil.mindfullconnect.android.ui.auth.AuthEventType
import dev.gusriil.mindfullconnect.android.utils.Result
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val accManager: AccountModule,
    private val authRepository: AuthRepository
) : ViewModel() {

    val authEvent = MutableLiveData<AuthEventType>()

    private val _errorEvent = MutableSharedFlow<String>()
    val errorEvent = _errorEvent.asSharedFlow()

    fun login(loginModel: UserLoginModel) {
        viewModelScope.launch {
            when (val result = authRepository.login(loginModel)) {
                is Result.Success -> {
                    result.data?.let { accManager.saveUser(it) }
                    authEvent.postValue(AuthEventType.LOGGED_IN)
                }

                is Result.Error -> {
                    _errorEvent.emit(result.message.toString())
                }
            }
        }
    }

    fun registration(registrationModel: UserRegistrationModel) {
        viewModelScope.launch {
            when (val registration = authRepository.registration(registrationModel)) {
                is Result.Success -> {
                    registration.data?.let { accManager.saveUser(it) }
                    authEvent.postValue(AuthEventType.SIGNED_UP)
                }

                is Result.Error -> {
                    _errorEvent.emit(registration.message.toString())
                }
            }
        }
    }

}