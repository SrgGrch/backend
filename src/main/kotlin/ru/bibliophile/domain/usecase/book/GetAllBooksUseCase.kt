package ru.bibliophile.domain.usecase.book

import ru.bibliophile.core.useCase.UnitUseCase
import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.repository.BookRepository

class GetAllBooksUseCase(
    private val bookRepository: BookRepository
) : UnitUseCase<List<Book>>() {
    override suspend fun run(): List<Book> = bookRepository.getAllBooks()
}