package dev.gusriil.mindfullconnect.backend.common.storage

import com.cloudinary.Cloudinary
import dev.gusriil.mindfullconnect.backend.infrastructure.Environment

class CloudinaryClient() {
    val cloudinary: Cloudinary = Cloudinary(
        mapOf(
            "cloud_name" to Environment.CL_NAME,
            "api_key" to Environment.CL_API_KEY,
            "api_secret" to Environment.CL_API_SECRET
        )
    )
}