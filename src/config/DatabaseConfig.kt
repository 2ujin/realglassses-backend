package com.realglasses.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseConfig {

    fun init() {
        Database.connect(HikariDataSource(hikari()))
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql://ec2-54-157-88-70.compute-1.amazonaws.com:5432/de7p8vfh0lugl8?user=fhxvzcpksahpfp&password=723c509872992b2f24e0902e51721013e5a4b58aba7f681c2ca5e87c9e91e9d9&sslmode=require"
        config.maximumPoolSize = 3
        config.isAutoCommit = true
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
        transaction {
            block()
        }
    }

}
