package com.example.mynews.data.news

import com.example.mynews.model.news.News

class FakeNewsRepository : NewsRepository {

    override suspend fun getNewsList(
        tab: String,
        page: Int,
        pageSize: Int
    ): List<News> {
        //模拟一下向后端发送请求，后端返回对应页的数据
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