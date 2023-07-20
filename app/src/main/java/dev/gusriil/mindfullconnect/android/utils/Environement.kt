package dev.gusriil.mindfullconnect.android.utils

import io.github.cdimascio.dotenv.dotenv

object Environement {
    val dotenv = dotenv {
        directory = "./assets"
        filename = "env" // instead of '.env', use 'env'
    }

    val API_KEY = dotenv["API_KEY"]
}