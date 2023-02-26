package ru.bibliophile.di

import org.koin.dsl.module
import ru.bibliophile.data.storage.book.BookStorage
import ru.bibliophile.data.storage.user.UserStorage

val storageModule = module {
    factory { UserStorage() }
    factory { BookStorage() }
}

