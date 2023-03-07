package ru.bibliophile.domain.repository

import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.model.Genre

interface BookRepository {
    fun getAllBooks(): List<Book>

    fun findBooksByTitle(title: String): List<Book>

    fun findBooksByOwnerId(id: Int): List<Book>

    fun findBookById(id: Int): Book?

    fun create(ownerId: Int, title: String, description: String, imageUrl: String, genre: Genre, author: String): Book
}