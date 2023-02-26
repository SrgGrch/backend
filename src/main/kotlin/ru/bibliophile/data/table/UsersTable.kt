package ru.bibliophile.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable() {
    val passwordHash = text("passwordHash")
    val login = text("login")
    val name = text("name")
    val photoUrl = text("photoUrl")
    val telegramLink = text("telegramLink").nullable()
    val whatsAppLink = text("whatsAppLink").nullable()

    init {
        index(true, login)
    }
}