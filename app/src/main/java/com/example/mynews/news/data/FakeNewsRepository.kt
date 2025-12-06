package com.example.mynews.news.data

import com.example.mynews.news.model.News

class FakeNewsRepository : NewsRepository {
    override suspend fun getNewsListForTab(tab: String): List<News> {
        return FakeNewsSource.getNewsListForTab(tab)
    }
}