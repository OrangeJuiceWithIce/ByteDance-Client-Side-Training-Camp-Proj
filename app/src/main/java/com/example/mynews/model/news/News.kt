package com.example.mynews.model.news

data class News(
    val id: String,
    val title: String,
    val source: String,
    val commentCount: Int,
    val time: String,
    val images: List<String> = emptyList(),
    val type: NewsType = NewsType.PureText//根据图片数量进行分类，给予不同的布局
)

enum class NewsType {
    PureText,
    SingleImage,
    MultiImage,
}