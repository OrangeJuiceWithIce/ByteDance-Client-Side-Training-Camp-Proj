package com.example.mynews.news.model

data class News(
    val id: String,
    val title: String,
    val source: String,
    val commentCount: Int,
    val time: String,
    val images: List<String> = emptyList(),
    val type: NewsType = NewsType.PureText
)

enum class NewsType {
    PureText,
    SingleImage,
    MultiImage,
}