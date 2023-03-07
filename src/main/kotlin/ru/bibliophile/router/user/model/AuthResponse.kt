package ru.bibliophile.router.user.model

import kotlinx.serialization.Serializable
import ru.bibliophile.domain.model.Token
import ru.bibliophile.domain.model.User

@Serializable
data class AuthResponse(
    val user: User,
    val token: Token
)
