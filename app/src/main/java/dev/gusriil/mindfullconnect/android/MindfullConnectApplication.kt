package dev.gusriil.mindfullconnect.android

import android.app.Application
import dev.gusriil.mindfullconnect.android.koin.accountModule
import dev.gusriil.mindfullconnect.android.koin.networkModule
import dev.gusriil.mindfullconnect.android.koin.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MindfullConnectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MindfullConnectApplication)
            modules(accountModule, viewModelsModule, networkModule)
        }
    }
}