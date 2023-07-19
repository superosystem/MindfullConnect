package dev.gusriil.mindfullconnect.backend.infrastructure

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import org.ktorm.database.Database

private val appCfg = HoconApplicationConfig(ConfigFactory.load())

// MYSQL
private val mysqlHost: String = appCfg.property("db.host").getString()
private val mysqlPort: String = appCfg.property("db.port").getString()
private val mysqlName: String = appCfg.property("db.name").getString()
private val mysqlUser: String = appCfg.property("db.user").getString()
private val mysqlPassword: String = appCfg.property("db.password").getString()
private val mysqlDriver: String = appCfg.property("db.driver").getString()

object DatabaseConnection {
    val mysql = Database.connect(
        "jdbc:mysql://$mysqlHost:$mysqlPort/$mysqlName",
        mysqlDriver,
        mysqlUser,
        mysqlPassword
    )
}