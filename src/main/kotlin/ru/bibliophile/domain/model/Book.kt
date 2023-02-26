package ru.bibliophile.domain.model

data class Book(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val genre: Genre,
    val author: String
)