package ru.bibliophile.data.storage.user

import org.jetbrains.exposed.sql.transactions.transaction
import ru.bibliophile.data.entity.UserEntity
import ru.bibliophile.data.table.UsersTable

class UserStorage {
    fun create(
        login: String,
        name: String,
        photoUrl: String,
        telegramLink: String?,
        whatsAppLink: String?,
        passwordHash: String
    ) = transaction {
        UserEntity.new {
            this.login = login
            this.name = name
            this.photoUrl = photoUrl
            this.telegramLink = telegramLink
            this.whatsAppLink = whatsAppLink
            this.passwordHash = passwordHash
        }.asUser()
    }

    fun findUserById(id: Int) = transaction { UserEntity.findById(id)?.asUser() }

    fun findUserByLogin(login: String) = transaction { findUserEntityByLogin(login)?.asUser() }

    fun findFullUserByLogin(login: String) = transaction { findUserEntityByLogin(login)?.asFullUser() }

    private fun findUserEntityByLogin(login: String) = transaction {
        UserEntity.find {
            UsersTable.login eq login
        }.singleOrNull()
    }
}