package com.example.mynews.ui.news

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import com.example.mynews.model.news.News

@Composable
fun NewsList(
    news: List<News>,
    onLoadMore: () -> Unit,
    onItemClick: (News) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        items(news, key = { it.id }) { item ->
            NewsItem(
                news = item,
                onClick = { onItemClick(item)}
            )
        }
    }

    //当lastVisible >= total - 5时应当加载更多
    val shouldLoadMore = remember {
        derivedStateOf {
            val total = listState.layoutInfo.totalItemsCount

            if (total == 0) return@derivedStateOf false

            val lastVisible = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0

            lastVisible >= total - 5
        }
    }

    //当shouldLoadMore从false->true时加载更多
    LaunchedEffect(shouldLoadMore.value) {
        if (shouldLoadMore.value) {
            onLoadMore()
        }
    }
}