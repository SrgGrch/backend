package ru.bibliophile.domain.usecase.book

import ru.bibliophile.core.useCase.ParamsUseCase
import ru.bibliophile.domain.model.Book
import ru.bibliophile.domain.repository.BookRepository

class FindBooksUseCase(
    private val bookRepository: BookRepository
) : ParamsUseCase<FindBooksUseCase.Input, List<Book>>() {

    override suspend fun run(params: Input): List<Book> = when (params) {
        is Input.OwnerId -> bookRepository.findBooksByOwnerId(params.id)
        is Input.Title -> bookRepository.findBooksByTitle(params.title)
    }

    sealed interface Input {
        data class Title(val title: String) : Input
        data class OwnerId(val id: Int) : Input
    }
}