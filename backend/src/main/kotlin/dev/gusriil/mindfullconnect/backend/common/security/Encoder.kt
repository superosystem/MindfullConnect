package dev.gusriil.mindfullconnect.backend.common.security

const val SECRET_KEY = "dSgVkYp3s6v9y/B?"
const val SECRET_IV = "KaPdSgVkXp2s5v8y"

class Encoder {
    fun String.encryptCBC(): String {
        val iv = IvParameterSpec(SECRET_IV.toByteArray())
        val keySpec = SecretKeySpec(SECRET_KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv)
        val crypt = cipher.doFinal(this.toByteArray())
        return String(Base64.getEncoder().encode(crypt))
    }

    fun String.decryptCBC(): String {
        val decodedByte: ByteArray = Base64.getDecoder().decode(this)
        val iv = IvParameterSpec(SECRET_IV.toByteArray())
        val keySpec = SecretKeySpec(SECRET_KEY.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv)
        return String(cipher.doFinal(decodedByte))
    }
}