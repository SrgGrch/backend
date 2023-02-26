package ru.bibliophile.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import ru.bibliophile.domain.model.User
import java.time.ZonedDateTime
import java.util.*


fun Application.configureSecurity() {
    install(Authentication) {
        jwt {
            verifier(JwtConfig.verifier)
            realm = "tech.blur"
            validate {
                val id = it.payload.getClaim("id").asInt()
                val name = it.payload.getClaim("name").asString()
                val login = it.payload.getClaim("login").asString()
                val photoUrl = it.payload.getClaim("photoUrl").asString()
                val telegramLink = it.payload.getClaim("telegramLink")?.asString()
                val whatsAppLink = it.payload.getClaim("whatsAppLink")?.asString()
                if (
                    id != null
                    && login != null
                    && name != null
                    && photoUrl != null
                ) User(id, login, name, photoUrl, telegramLink, whatsAppLink)
                else null
            }
        }
    }
}

object JwtConfig {
    private const val secret = "OZ6RJPQdzYNha78szaLT"
    private const val issuer = "blur.tech"
    private val algorithm = Algorithm.HMAC512(secret)
    private val expiration: Date
        get() = Date.from(ZonedDateTime.now().plusDays(3650).toInstant())

    val verifier: JWTVerifier = JWT.require(algorithm).withIssuer(issuer).build()

    fun generateToken(user: User): String =
        JWT
            .create()
            .withSubject("Authentication")
            .withIssuer(issuer)
            .withExpiresAt(expiration)
            .withClaim("id", user.id)
            .withClaim("login", user.login)
            .withClaim("name", user.name)
            .withClaim("photoUrl", user.photoUrl)
            .withClaim("telegramLink", user.telegramLink)
            .withClaim("whatsAppLink", user.whatsAppLink)
            .sign(algorithm)
}

