package ru.bibliophile.router.book.model

import kotlinx.serialization.Serializable
import ru.bibliophile.domain.model.Genre
import ru.bibliophile.domain.model.User

@Serializable
data class BookResponse(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val genre: Genre,
    val author: String,
    val user: User
)