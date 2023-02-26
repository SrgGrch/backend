package ru.bibliophile.di

import org.koin.dsl.module
import ru.bibliophile.domain.usecase.user.AuthUserUseCase
import ru.bibliophile.domain.usecase.user.CreateUserUseCase
import ru.bibliophile.domain.usecase.user.GetUserUseCase

val useCaseModule = module {
    factory { GetUserUseCase(get()) }
    factory { CreateUserUseCase(get()) }
    factory { AuthUserUseCase(get()) }
}