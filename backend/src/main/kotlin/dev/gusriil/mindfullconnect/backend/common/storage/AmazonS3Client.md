```kotlin
package dev.gusriil.mindfullconnect.backend.common.storage

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import io.ktor.server.config.*

// Service
class AmazonS3Client(config: HoconApplicationConfig) {
private val accessKey = config.property("aws.accessKey").getString()
private val secretKey = config.property("aws.secretKey").getString()

    var credentials = BasicAWSCredentials(accessKey, secretKey)

    val s3Client: AmazonS3 = AmazonS3ClientBuilder.standard()
        .withRegion("eu-central-1")
        .withCredentials(AWSStaticCredentialsProvider(credentials))
        .build()
}


// Controller
suspend fun uploadAvatar(photo: MultiPartData, userId: Long): AvatarModel {
    var resInputStream: InputStream? = null
    var ext: String? = null
    photo.forEachPart { part ->
        when (part) {
            is PartData.FileItem -> {
                resInputStream = part.streamProvider()
                ext = part.originalFileName
            }
            else -> {
                throw MultiPartDataNotFoundException()
            }
        }
    }

    val extension = try {
        "." + ext?.split(".")?.get(1)
    } catch (ext: Exception) {
        ""
    }

    val key = UUID.randomUUID().toString() + System.currentTimeMillis() + extension
    val por = PutObjectRequest(
        "perpetio-ktor-chat",
        key,
        resInputStream,
        ObjectMetadata()
    )
    amazonClient.s3Client.putObject(por)

    val avatarPresignedUrl = getAvatarPresignedUrl(key)
    userRepo.updateUserAvatar(userId, avatarPresignedUrl, key)
    return AvatarModel(avatarPresignedUrl)
}

private fun getAvatarPresignedUrl(keyName: String): String {

    val expiration = LocalDateTime.now().plusDays(6)

    val generatePresignedUrlRequest = GeneratePresignedUrlRequest("perpetio-ktor-chat", keyName)
        .withMethod(com.amazonaws.HttpMethod.GET)
        .withExpiration(Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant()))

    return amazonClient.s3Client.generatePresignedUrl(generatePresignedUrlRequest).toString()
}

```