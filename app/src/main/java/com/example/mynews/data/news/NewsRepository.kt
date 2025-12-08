package com.example.mynews.data.news

import com.example.mynews.model.news.News

interface NewsRepository {
    suspend fun getNewsList(
        tab: String,
        page: Int,
        pageSize: Int
    ): List<News>
}