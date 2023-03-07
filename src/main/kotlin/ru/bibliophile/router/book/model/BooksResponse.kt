package ru.bibliophile.router.book.model

import kotlinx.serialization.Serializable
import ru.bibliophile.domain.model.Book

@Serializable
data class BooksResponse(
    private val books: List<Book>
)