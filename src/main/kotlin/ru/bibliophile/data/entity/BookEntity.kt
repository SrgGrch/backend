package ru.bibliophile.data.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import ru.bibliophile.data.table.BooksTable

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(BooksTable)

    var user by UserEntity referencedOn BooksTable.ownerId
    var ownerId by BooksTable.ownerId
    var title by BooksTable.title
    var imageUrl by BooksTable.imageUrl
    var description by BooksTable.description
    var genre by BooksTable.genre
    var author by BooksTable.author
}