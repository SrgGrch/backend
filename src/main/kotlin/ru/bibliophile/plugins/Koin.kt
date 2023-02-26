package ru.bibliophile.plugins

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import ru.bibliophile.di.commonModule
import ru.bibliophile.di.repositoryModule
import ru.bibliophile.di.storageModule
import ru.bibliophile.di.useCaseModule

fun Application.configureKoin() {
    install(Koin) {
        modules(
            storageModule,
            useCaseModule,
            repositoryModule,
            commonModule
        )
    }
}