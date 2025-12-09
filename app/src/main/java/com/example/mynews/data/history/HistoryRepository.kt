package com.example.mynews.data.history

import com.example.mynews.core.database.dao.HistoryDao
import com.example.mynews.model.history.HistoryEntry
import com.example.mynews.model.news.News

//对Sqlite的操作进行封装
class HistoryRepository(private val dao: HistoryDao) {
    fun recordHistory(news: News) {
        val entity = HistoryEntry(
            newsId = news.id,
            title = news.title,
            readTime = System.currentTimeMillis()
        )
        dao.insert(entity)
    }
    fun getHistory(): List<HistoryEntry> {
        return dao.getAll()
    }

    fun clearHistory() {
        dao.clear()
    }
}