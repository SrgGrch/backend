package ru.bibliophile.data.table

import org.jetbrains.exposed.dao.id.IntIdTable
import ru.bibliophile.domain.model.Genre

object BooksTable : IntIdTable() {
    val ownerId = reference("ownerId", UsersTable)
    val title = text("title")
    val imageUrl = text("imageUrl")
    val description = text("description")
    val genre = enumeration<Genre>("genre")
    val author = text("author")
}