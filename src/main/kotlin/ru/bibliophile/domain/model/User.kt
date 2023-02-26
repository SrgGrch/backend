package ru.bibliophile.domain.model

import io.ktor.server.auth.*
import kotlinx.serialization.Serializable

@Serializable
open class User(
    val id: Int,
    val login: String,
    val name: String,
    val photoUrl: String,
    val telegramLink: String? = null,
    val whatsAppLink: String? = null,
) : Principal {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (login != other.login) return false
        if (name != other.name) return false
        if (photoUrl != other.photoUrl) return false
        if (telegramLink != other.telegramLink) return false
        if (whatsAppLink != other.whatsAppLink) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + login.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + photoUrl.hashCode()
        result = 31 * result + (telegramLink?.hashCode() ?: 0)
        result = 31 * result + (whatsAppLink?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "User(id=$id, login='$login', name='$name', photoUrl='$photoUrl', telegramLink=$telegramLink, whatsAppLink=$whatsAppLink)"
    }
}
