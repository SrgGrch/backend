package ru.bibliophile.domain.usecase.user

import org.mindrot.jbcrypt.BCrypt
import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.Token
import ru.bibliophile.domain.model.User
import ru.bibliophile.domain.repository.UserRepository
import ru.bibliophile.plugins.JwtConfig
import ru.bibliophile.router.user.model.LoginRequest

class AuthUserUseCase(
    private val userRepository: UserRepository
) : ParamsUseCase<LoginRequest, Pair<User, Token>?>() {
    override suspend fun run(params: LoginRequest): Pair<User, Token>? {
        return userRepository.getFullUser(params.login)?.let { user ->
            val token = if (BCrypt.checkpw(params.password, user.passwordHash))
                JwtConfig.generateToken(user.asUser())
            else null

            token?.let { user.asUser() to Token(it) }
        }
    }
}