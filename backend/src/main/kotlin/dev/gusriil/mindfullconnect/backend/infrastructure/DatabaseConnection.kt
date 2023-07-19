package dev.gusriil.mindfullconnect.backend.infrastructure

import org.ktorm.database.Database

object DatabaseConnection {
    val mysql = Database.connect(
        "jdbc:mysql://${Environment.DB_HOST}:${Environment.DB_PORT}/${Environment.DB_NAME}",
        "com.mysql.cj.jdbc.Driver",
        Environment.DB_USER,
        Environment.DB_PASSWORD
    )
}