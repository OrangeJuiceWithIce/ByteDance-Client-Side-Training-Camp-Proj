package com.example.mynews.main.ui.components

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*

@Composable
fun BottomNavBar() {
    var selected by remember { mutableIntStateOf(2) }

    NavigationBar {
        NavigationBarItem(
            selected = selected == 0,
            onClick = { selected = 0 },
            icon = { Icon(Icons.Default.Home, null) },
            label = { Text("首页") }
        )
        NavigationBarItem(
            selected = selected == 1,
            onClick = { selected = 1 },
            icon = { Icon(Icons.Default.PlayArrow, null) },
            label = { Text("视频") }
        )
        NavigationBarItem(
            selected = selected == 2,
            onClick = { selected = 2 },
            icon = { Icon(Icons.Default.Search, null) },
            label = { Text("搜索") }
        )
        NavigationBarItem(
            selected = selected == 3,
            onClick = { selected = 3},
            icon = { Icon(Icons.Default.DateRange, null) },
            label = { Text("任务") }
        )
        NavigationBarItem(
            selected = selected == 4,
            onClick = { selected = 4 },
            icon = { Icon(Icons.Default.Person, null) },
            label = { Text("我的") }
        )
    }
}
