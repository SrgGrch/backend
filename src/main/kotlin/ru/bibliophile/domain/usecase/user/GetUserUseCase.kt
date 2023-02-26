package ru.bibliophile.domain.usecase.user

import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.User
import ru.bibliophile.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) : ParamsUseCase<GetUserUseCase.Input, User?>() {
    override suspend fun run(params: Input): User? {
        return userRepository.getUser(params.login)
    }

    data class Input(val login: String)
}