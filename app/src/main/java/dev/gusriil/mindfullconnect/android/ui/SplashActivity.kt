package dev.gusriil.mindfullconnect.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.gusriil.mindfullconnect.android.data.AccountModule
import dev.gusriil.mindfullconnect.android.ui.auth.AuthActivity
import dev.gusriil.mindfullconnect.android.ui.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val accManager: AccountModule by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (accManager.getToken().isNotEmpty()) {
            MainActivity.startWithSingleTop(this)
        } else AuthActivity.start(this)
    }

}