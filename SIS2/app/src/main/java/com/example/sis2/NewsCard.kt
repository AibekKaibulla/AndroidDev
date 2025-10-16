package com.example.sis2

data class NewsCard(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    var isLiked: Boolean = false
)
