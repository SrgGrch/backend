package ru.bibliophile.data

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import ru.bibliophile.data.table.BooksTable
import ru.bibliophile.data.table.UsersTable

object BookwormDatabase {
    fun connect(jdbcDatabaseUrl: String) {
        Database.connect(createHikariDS(jdbcDatabaseUrl))
    }

    fun createTablesIfNeeded() {
        transaction {
            SchemaUtils.createMissingTablesAndColumns(
                UsersTable,
                BooksTable
            )
        }
    }

    private fun createHikariDS(jdbcDatabaseUrl: String): HikariDataSource {
        val config = HikariConfig()
        with(config) {
            jdbcUrl = jdbcDatabaseUrl
            maximumPoolSize = 30
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            username = "postgres"
            password = "1234"
            validate()
        }

        return HikariDataSource(config)
    }
}