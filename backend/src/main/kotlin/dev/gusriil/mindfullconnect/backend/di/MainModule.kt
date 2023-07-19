package dev.gusriil.mindfullconnect.backend.di

import dev.gusriil.mindfullconnect.backend.common.security.TokenManager
import dev.gusriil.mindfullconnect.backend.infrastructure.DatabaseConnection
import org.koin.dsl.module

val mainModule = module {
    single {
        DatabaseConnection.mysql
    }

//    single {
//        HoconApplicationConfig(ConfigFactory.load())
//    }

    single {
        TokenManager()
    }
}