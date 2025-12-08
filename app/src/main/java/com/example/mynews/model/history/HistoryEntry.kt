package com.example.mynews.model.history

data class HistoryEntry(
    val id: Long?=null,
    val newsId: String,
    val title: String,
    val readTime: Long
)