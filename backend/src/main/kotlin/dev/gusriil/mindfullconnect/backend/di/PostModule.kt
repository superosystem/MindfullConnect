package dev.gusriil.mindfullconnect.backend.di

import dev.gusriil.mindfullconnect.backend.controller.PostController
import dev.gusriil.mindfullconnect.backend.infrastructure.post.PostRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.post.PostRepositoryImpl
import dev.gusriil.mindfullconnect.backend.infrastructure.postlike.PostLikeRepository
import dev.gusriil.mindfullconnect.backend.infrastructure.postlike.PostLikeRepositoryImpl
import org.koin.dsl.module

val postModule = module {
    single<PostRepository> {
        PostRepositoryImpl(get())
    }

    single<PostLikeRepository> {
        PostLikeRepositoryImpl(get())
    }

    single {
        PostController(get(), get())
    }
}