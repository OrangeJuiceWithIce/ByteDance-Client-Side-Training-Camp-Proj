package com.example.mynews.news.data

import com.example.mynews.news.model.News

interface NewsRepository {
    suspend fun getNewsList(
        tab: String,
        page: Int,
        pageSize: Int
    ): List<News>
}