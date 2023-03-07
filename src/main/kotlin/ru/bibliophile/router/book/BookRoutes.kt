package ru.bibliophile.router.book

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get
import ru.bibliophile.domain.usecase.book.FindBookUseCase
import ru.bibliophile.domain.usecase.book.FindBooksUseCase
import ru.bibliophile.domain.usecase.book.GetAllBooksUseCase
import ru.bibliophile.domain.usecase.user.GetUserUseCase
import ru.bibliophile.router.book.model.BookResponse
import ru.bibliophile.router.book.model.BooksResponse

fun Routing.bookRoutes(
    getAllBooksUseCase: GetAllBooksUseCase = get(),
    findBookUseCase: FindBookUseCase = get(),
    findBooksUseCase: FindBooksUseCase = get(),
    getUserUseCase: GetUserUseCase = get()
) {
    val route = "books"

    get(route) {
        val query = call.request.queryParameters["query"]

        call.respond(
            BooksResponse(
                if (query.isNullOrBlank()) {
                    getAllBooksUseCase.execute()
                } else findBooksUseCase.execute(FindBooksUseCase.Input.Title(query))

            )
        )
    }

    get("$route/{id}") {
        val id = call.parameters["id"]!!.toInt()

        findBookUseCase.execute(id)?.let { book ->
            getUserUseCase.execute(GetUserUseCase.Input.Id(book.ownerId))?.let { user ->
                with(book) {
                    call.respond(
                        BookResponse(
                            id,
                            title,
                            description,
                            imageUrl,
                            genre,
                            author,
                            user
                        )
                    )
                }
            } ?: call.respond(HttpStatusCode.NotFound)
        } ?: call.respond(HttpStatusCode.NotFound)
    }

    get("$route/owner/{id}") {
        val id = call.parameters["id"]!!.toInt()

        call.respond(
            BooksResponse(
                findBooksUseCase.execute(FindBooksUseCase.Input.OwnerId(id))
            )
        )
    }
}