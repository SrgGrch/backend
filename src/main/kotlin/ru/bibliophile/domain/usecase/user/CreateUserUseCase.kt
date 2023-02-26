package ru.bibliophile.domain.usecase.user

import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.User
import ru.bibliophile.domain.repository.UserRepository

class CreateUserUseCase(
    private val userRepository: UserRepository
) : ParamsUseCase<CreateUserUseCase.Input, User>() {
    override suspend fun run(params: Input): User {
        return with(params) {
            userRepository.createUser(login, name, photoUrl, telegramLink, whatsAppLink, passwordHash)
        }
    }

    data class Input(
        val login: String,
        val name: String,
        val photoUrl: String,
        val telegramLink: String?,
        val whatsAppLink: String?,
        val passwordHash: String
    )
}