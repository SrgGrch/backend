package ru.bibliophile.di

import org.koin.dsl.module
import ru.bibliophile.data.repository.UserRepositoryImpl
import ru.bibliophile.domain.repository.UserRepository

val repositoryModule = module {
    factory<UserRepository> { UserRepositoryImpl(get(), get()) }
}