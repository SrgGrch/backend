package ru.bibliophile

import io.ktor.server.application.*
import io.ktor.server.netty.*
import ru.bibliophile.plugins.*

fun main(args: Array<String>): Unit = EngineMain.main(args)
fun Application.module() {
    configureKoin()
    configureSecurity()
    configureSerialization()
    configureDatabases()
    configureRouting()
}
