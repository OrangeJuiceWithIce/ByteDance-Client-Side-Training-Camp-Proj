package com.example.mynews.ui.history.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.mynews.model.history.HistoryEntry
import com.example.mynews.ui.history.HistoryItem

@Composable
fun HistoryList(
    history: List<HistoryEntry>,
    onItemClick: (HistoryEntry) -> Unit
) {
    LazyColumn {
        items(history) { item ->
            HistoryItem(
                item = item,
                onClick = { onItemClick(item) }
            )
        }
    }
}