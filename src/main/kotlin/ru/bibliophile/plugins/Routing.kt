package ru.bibliophile.plugins

import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.bibliophile.router.book.bookRoutes
import ru.bibliophile.router.user.accountRoutes

fun Application.configureRouting() {
    install(Resources)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        accountRoutes()
        bookRoutes()
    }
}
