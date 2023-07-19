package dev.gusriil.mindfullconnect.backend.common.storage

import com.cloudinary.Cloudinary
import io.ktor.server.config.*

class CloudinaryClient(config: HoconApplicationConfig) {

    private val cloudName = config.property("cloudinary.cloudName").getString()
    private val apiKey = config.property("cloudinary.apiKey").getString()
    private val apiSecret = config.property("cloudinary.apiSecret").getString()

    val cloudinary: Cloudinary =  Cloudinary(mapOf(
        "cloud_name" to cloudName,
        "api_key" to apiKey,
        "api_secret" to apiSecret
    ))
}