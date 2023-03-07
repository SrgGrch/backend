package ru.bibliophile.data.repository

import ru.bibliophile.data.storage.book.BookStorage
import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.model.Genre
import ru.bibliophile.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookStorage: BookStorage
) : BookRepository {
    override fun getAllBooks(): List<Book> = bookStorage.getAllBooks()

    override fun findBooksByTitle(title: String): List<Book> = bookStorage.findBooksByTitle(title)

    override fun findBooksByOwnerId(id: Int): List<Book> = bookStorage.findBooksByOwnerId(id)

    override fun findBookById(id: Int): Book? = bookStorage.findBookById(id)

    override fun create(
        ownerId: Int,
        title: String,
        description: String,
        imageUrl: String,
        genre: Genre,
        author: String
    ): Book = bookStorage.create(ownerId, title, description, imageUrl, genre, author)
}