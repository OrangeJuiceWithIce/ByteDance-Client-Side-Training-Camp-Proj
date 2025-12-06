package com.example.mynews.news.data

import com.example.mynews.news.model.News

class FakeNewsRepository : NewsRepository {

    override suspend fun getNewsList(
        tab: String,
        page: Int,
        pageSize: Int
    ): List<News> {

        val fullList = FakeNewsSource.getNewsListForTab(tab)
        val fromIndex = page * pageSize
        val toIndex = minOf(fromIndex + pageSize, fullList.size)

        return if (fromIndex < fullList.size) {
            fullList.subList(fromIndex, toIndex)
        } else {
            emptyList()
        }
    }
}