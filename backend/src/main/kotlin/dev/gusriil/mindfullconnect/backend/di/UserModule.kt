package dev.gusriil.mindfullconnect.backend.di

import dev.gusriil.mindfullconnect.backend.common.storage.CloudinaryClient
import dev.gusriil.mindfullconnect.backend.controller.UserController
import dev.gusriil.mindfullconnect.backend.infrastructure.user.UserRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.user.UserRepositoryImpl
import org.koin.dsl.module

val userModule = module {
    single {
        CloudinaryClient()
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }

    single {
        UserController(get(), get(), get())
    }
}