package com.example.mynews.model.main

import com.example.mynews.model.news.News

data class MainUiState(
    val selectedTab: String = "推荐",
    val newsList: List<News> = emptyList(),
    val isRefreshing: Boolean = false
)
