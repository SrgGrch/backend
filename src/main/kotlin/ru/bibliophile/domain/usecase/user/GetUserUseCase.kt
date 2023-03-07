package ru.bibliophile.domain.usecase.user

import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.User
import ru.bibliophile.domain.repository.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository
) : ParamsUseCase<GetUserUseCase.Input, User?>() {
    override suspend fun run(params: Input): User? {
        return when (params) {
            is Input.Id -> userRepository.getUser(params.id)
            is Input.Login -> userRepository.getUser(params.login)
        }
    }

    sealed interface Input {
        data class Login(val login: String) : Input
        data class Id(val id: Int) : Input
    }
}