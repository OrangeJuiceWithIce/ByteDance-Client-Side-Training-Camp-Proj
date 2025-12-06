package com.example.mynews.news.data

import com.example.mynews.news.model.News

interface NewsRepository {
    suspend fun getNewsListForTab(tab: String): List<News>
}