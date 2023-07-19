package dev.gusriil.mindfullconnect.backend.infrastructure

import io.github.cdimascio.dotenv.Dotenv

object Environment {
    private val env = Dotenv.configure().ignoreIfMalformed().load()

    // Server
    val SERVER_PORT: String = env["PORT"]
    val SECRET_KEY: String = env["SECRET_KEY"]
    val SECRET_IV: String = env["SECRET_IV"]

    // Database
    val DB_HOST: String = env["DBHOST"]
    val DB_PORT: String = env["DBPORT"]
    val DB_NAME: String = env["DBNAME"]
    val DB_USER: String = env["DBUSER"]
    val DB_PASSWORD: String = env["DBPASSWORD"]

    // JWT
    val JWT_SECRET: String = env["JWTSECRET"]
    val JWT_ISSUER: String = env["JWTISSUER"]
    val JWT_AUDIENCE: String = env["JWTAUDIENCE"]
    val JWT_REALM: String = env["JWTREALM"]

    // Cloudinary
    val CL_NAME: String = env["CLNAME"]
    val CL_API_KEY: String = env["CLAPIKEY"]
    val CL_API_SECRET: String = env["CLAPISECRET"]

}