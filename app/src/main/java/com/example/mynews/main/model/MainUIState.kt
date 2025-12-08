package com.example.mynews.main.model

import com.example.mynews.news.model.News

data class MainUiState(
    val selectedTab: String = "推荐",
    val newsList: List<News> = emptyList(),
    val isRefreshing: Boolean = false
)
