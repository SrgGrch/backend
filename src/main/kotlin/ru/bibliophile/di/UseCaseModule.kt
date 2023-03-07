package ru.bibliophile.di

import org.koin.dsl.module
import ru.bibliophile.domain.usecase.book.FindBookUseCase
import ru.bibliophile.domain.usecase.book.FindBooksUseCase
import ru.bibliophile.domain.usecase.book.GetAllBooksUseCase
import ru.bibliophile.domain.usecase.user.AuthUserUseCase
import ru.bibliophile.domain.usecase.user.CreateUserUseCase
import ru.bibliophile.domain.usecase.user.GetUserUseCase

val useCaseModule = module {
    factory { GetUserUseCase(get()) }
    factory { CreateUserUseCase(get()) }
    factory { AuthUserUseCase(get()) }

    factory { GetAllBooksUseCase(get()) }
    factory { FindBookUseCase(get()) }
    factory { FindBooksUseCase(get()) }
}