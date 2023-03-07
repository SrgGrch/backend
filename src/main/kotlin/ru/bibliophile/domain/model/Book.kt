package ru.bibliophile.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val genre: Genre,
    val author: String
)