package ru.bibliophile.data.storage.book

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.transactions.transaction
import ru.bibliophile.data.entity.BookEntity
import ru.bibliophile.data.table.BooksTable
import ru.bibliophile.data.table.UsersTable
import ru.bibliophile.domain.model.Genre

class BookStorage {
    fun create(
        ownerId: Int,
        title: String,
        description: String,
        imageUrl: String,
        genre: Genre,
        author: String
    ) = transaction {
        BookEntity.new {
            this.ownerId = EntityID(ownerId, UsersTable)
            this.title = title
            this.description = description
            this.imageUrl = imageUrl
            this.genre = genre
            this.author = author
        }.asBook()
    }

    fun findBooksEntityByOwnerId(ownerId: Int) = transaction {
        BookEntity.find {
            BooksTable.ownerId eq ownerId
        }.map { it.asBook() }.toList()
    }
}