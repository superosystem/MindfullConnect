package dev.gusriil.mindfullconnect.android.koin

import dev.gusriil.mindfullconnect.android.data.AccountModule
import dev.gusriil.mindfullconnect.android.data.DataStoreManager
import dev.gusriil.mindfullconnect.android.network.RestApiBuilder
import dev.gusriil.mindfullconnect.android.network.WebSocketBuilder
import dev.gusriil.mindfullconnect.android.repository.auth.AuthRepository
import dev.gusriil.mindfullconnect.android.repository.auth.AuthRepositoryImpl
import dev.gusriil.mindfullconnect.android.repository.chat.ChatRepository
import dev.gusriil.mindfullconnect.android.repository.chat.ChatRepositoryImpl
import dev.gusriil.mindfullconnect.android.repository.post.PostRepository
import dev.gusriil.mindfullconnect.android.repository.post.PostRepositoryImpl
import dev.gusriil.mindfullconnect.android.repository.user.UserRepository
import dev.gusriil.mindfullconnect.android.repository.user.UserRepositoryImpl
import dev.gusriil.mindfullconnect.android.ui.auth.viewmodel.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {
    single { DataStoreManager(get()) }
    single { AccountModule(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<PostRepository> { PostRepositoryImpl(get()) }
    single<ChatRepository> { ChatRepositoryImpl(get()) }
}

val networkModule = module {
    single { RestApiBuilder(get()) }
    single { WebSocketBuilder(get()) }
}

val viewModelsModule = module {
    viewModel { AuthViewModel(get(), get()) }
}