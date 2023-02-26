package ru.bibliophile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val token: String,
    val type: String = "Bearer"
)