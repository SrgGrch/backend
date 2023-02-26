package ru.bibliophile.domain.repository

import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.model.FullUser
import ru.bibliophile.domain.model.User

interface UserRepository {
    fun createUser(
        login: String,
        name: String,
        photoUrl: String,
        telegramLink: String?,
        whatsAppLink: String?,
        passwordHash: String
    ): User

    fun getUser(login: String): User?

    fun getUserWithBooks(login: String): UserWithBooks?

    fun getUser(id: Int): User?

    fun getUserWithBooks(id: Int): UserWithBooks?

    fun getFullUser(login: String): FullUser?

    data class UserWithBooks(
        val user: User,
        val books: List<Book>
    )
}