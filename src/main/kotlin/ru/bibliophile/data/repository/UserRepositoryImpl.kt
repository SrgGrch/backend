package ru.bibliophile.data.repository

import ru.bibliophile.data.storage.book.BookStorage
import ru.bibliophile.data.storage.user.UserStorage
import ru.bibliophile.domain.model.FullUser
import ru.bibliophile.domain.model.User
import ru.bibliophile.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userStorage: UserStorage,
    private val bookStorage: BookStorage
) : UserRepository {
    override fun createUser(
        login: String,
        name: String,
        photoUrl: String,
        telegramLink: String?,
        whatsAppLink: String?,
        passwordHash: String
    ) = userStorage.create(login, name, photoUrl, telegramLink, whatsAppLink, passwordHash)

    override fun getUser(login: String) = userStorage.findUserByLogin(login)
    override fun getUser(id: Int): User? = userStorage.findUserById(id)

    override fun getUserWithBooks(login: String): UserRepository.UserWithBooks? {
        return userStorage.findUserByLogin(login)?.let {
            UserRepository.UserWithBooks(
                it,
                bookStorage.findBooksByOwnerId(it.id)
            )
        }
    }

    override fun getUserWithBooks(id: Int): UserRepository.UserWithBooks? {
        return userStorage.findUserById(id)?.let {
            UserRepository.UserWithBooks(
                it,
                bookStorage.findBooksByOwnerId(id)
            )
        }
    }

    override fun getFullUser(login: String): FullUser? = userStorage.findFullUserByLogin(login)
}