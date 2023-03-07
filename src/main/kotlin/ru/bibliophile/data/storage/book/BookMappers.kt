package ru.bibliophile.data.storage.book

import ru.bibliophile.data.entity.BookEntity
import ru.bibliophile.domain.model.Book

fun BookEntity.asBook() = Book(
    id.value,
    ownerId.value,
    title,
    description,
    imageUrl,
    genre,
    author,
)