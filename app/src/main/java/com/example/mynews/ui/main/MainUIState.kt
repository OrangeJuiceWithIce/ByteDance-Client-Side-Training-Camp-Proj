package com.example.mynews.ui.main

import com.example.mynews.news.model.News

data class MainUiState(
    val selectedTab: String = "推荐",
    val newsList: List<News> = emptyList()
)
