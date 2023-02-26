package ru.bibliophile.router.user

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import org.mindrot.jbcrypt.BCrypt
import ru.bibliophile.domain.model.Token
import ru.bibliophile.domain.usecase.user.AuthUserUseCase
import ru.bibliophile.domain.usecase.user.CreateUserUseCase
import ru.bibliophile.domain.usecase.user.GetUserUseCase
import ru.bibliophile.plugins.JwtConfig
import ru.bibliophile.router.user.model.AuthResponse
import ru.bibliophile.router.user.model.CreateUserRequest
import ru.bibliophile.router.user.model.LoginRequest

fun Routing.accountRoutes(
    createUserUseCase: CreateUserUseCase = get(),
    authUserUseCase: AuthUserUseCase = get(),
    getUserUseCase: GetUserUseCase = get()
) {
    val route = "user"

    post<CreateUserRequest>("$route/register") {
        with(it) {
            createUserUseCase.execute(
                CreateUserUseCase.Input(
                    login,
                    name,
                    "https://cdn.dribbble.com/users/5534/screenshots/14230133/media/e2f853f8232acad78bf143c32f2f3a04.jpg",
                    telegramLink,
                    whatsAppLink,
                    BCrypt.hashpw(password, BCrypt.gensalt()),
                )
            )
        }.let { user ->
            call.respond(
                AuthResponse(
                    user,
                    Token(
                        JwtConfig.generateToken(user),
                        "Bearer"
                    )
                )
            )
        }
    }

    post<LoginRequest>("$route/login") {
        authUserUseCase.execute(it)?.let { (user, token) ->
            call.respond(
                AuthResponse(
                    user,
                    token
                )
            )
        } ?: call.respond(HttpStatusCode.NotFound)
    }

    get("$route/{login}") {
        val login = call.parameters["login"]!!

        getUserUseCase.execute(GetUserUseCase.Input(login))?.let { user ->
            call.respond(
                user
            )
        } ?: call.respond(HttpStatusCode.NotFound)
    }
}