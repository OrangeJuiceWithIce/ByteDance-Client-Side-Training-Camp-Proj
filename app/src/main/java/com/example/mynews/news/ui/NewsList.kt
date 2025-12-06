package com.example.mynews.news.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynews.news.model.News

@Composable
fun NewsList(news: List<News>) {
    LazyColumn {
        items(news) { item ->
            NewsItem(news = item)
        }
    }
}