package ru.bibliophile.domain.usecase.book

import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.repository.BookRepository

class FindBookUseCase(
    private val bookRepository: BookRepository
) : ParamsUseCase<Int, Book?>() {

    override suspend fun run(params: Int): Book? = bookRepository.findBookById(params)
}