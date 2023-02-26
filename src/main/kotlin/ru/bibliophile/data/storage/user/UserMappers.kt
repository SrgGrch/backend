package ru.bibliophile.data.storage.user

import ru.bibliophile.data.entity.UserEntity
import ru.bibliophile.domain.model.FullUser
import ru.bibliophile.domain.model.User

fun UserEntity.asUser() = User(
    id.value,
    login,
    name,
    photoUrl,
    telegramLink,
    whatsAppLink
)

fun UserEntity.asFullUser() = FullUser(
    id.value,
    login,
    name,
    photoUrl,
    telegramLink,
    whatsAppLink,
    passwordHash
)