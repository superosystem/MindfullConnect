package dev.gusriil.mindfullconnect.backend.common.security

import dev.gusriil.mindfullconnect.backend.infrastructure.Environment
import io.ktor.utils.io.core.*
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object PasswordEncoder {
    fun String.encryptCBC(): String {
        val iv = IvParameterSpec(Environment.SECRET_IV.toByteArray())
        val keySpec = SecretKeySpec(Environment.SECRET_KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv)
        val crypt = cipher.doFinal(this.toByteArray())
        return String(Base64.getEncoder().encode(crypt))
    }

    fun String.decryptCBC(): String {
        val decodedByte: ByteArray = Base64.getDecoder().decode(this)
        val iv = IvParameterSpec(Environment.SECRET_IV.toByteArray())
        val keySpec = SecretKeySpec(Environment.SECRET_KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv)
        return String(cipher.doFinal(decodedByte))
    }
}