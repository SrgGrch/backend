package ru.bibliophile.router.user.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val login: String, val password: String)
