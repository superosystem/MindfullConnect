package dev.gusriil.mindfullconnect.backend.di

import dev.gusriil.mindfullconnect.backend.controller.ChatController
import dev.gusriil.mindfullconnect.backend.infrastructure.message.MessageRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.message.MessageRepositoryImpl
import dev.gusriil.mindfullconnect.backend.infrastructure.roomuser.RoomUserRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.roomuser.RoomUserRepositoryImpl
import org.koin.dsl.module

val roomModule = module {
    single<MessageRepository> {
        MessageRepositoryImpl(get())
    }

    single<RoomUserRepository> {
        RoomUserRepositoryImpl(get())
    }

    single {
        ChatController(get(), get(), get())
    }
}