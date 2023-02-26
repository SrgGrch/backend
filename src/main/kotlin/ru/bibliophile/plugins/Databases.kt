package ru.bibliophile.plugins

import io.ktor.server.application.*
import ru.bibliophile.data.BookwormDatabase

fun Application.configureDatabases() {
    BookwormDatabase.connect(environment.config.property("ktor.jdbcDatabaseUrl").getString())
    BookwormDatabase.createTablesIfNeeded()
}
