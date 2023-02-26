package ru.bibliophile.router.user.model

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val login: String,
    val name: String,
    val password: String,
    val telegramLink: String? = null,
    val whatsAppLink: String? = null
)