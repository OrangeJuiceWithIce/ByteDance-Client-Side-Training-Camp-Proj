package com.example.mynews.ui.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mynews.model.history.HistoryEntry
import com.example.mynews.util.formatTimestamp

@Composable
fun HistoryItem(
    item: HistoryEntry,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(item.title)
            Spacer(Modifier.height(4.dp))
            Text("访问时间：${formatTimestamp(item.readTime)}")
        }
    }
}
