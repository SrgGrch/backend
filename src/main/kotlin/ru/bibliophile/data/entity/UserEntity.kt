package ru.bibliophile.data.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import ru.bibliophile.data.table.UsersTable

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserEntity>(UsersTable)

    var passwordHash by UsersTable.passwordHash
    var login by UsersTable.login
    var name by UsersTable.name
    var photoUrl by UsersTable.photoUrl
    var telegramLink by UsersTable.telegramLink
    var whatsAppLink by UsersTable.whatsAppLink
}