package ru.bibliophile.domain.model

class FullUser(
    id: Int,
    login: String,
    name: String,
    photoUrl: String,
    telegramLink: String? = null,
    whatsAppLink: String? = null,
    val passwordHash: String,
) : User(id, login, name, photoUrl, telegramLink, whatsAppLink) {
    fun asUser(): User = User(id, login, name, photoUrl, telegramLink, whatsAppLink)
}