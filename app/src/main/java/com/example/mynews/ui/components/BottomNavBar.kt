package com.example.mynews.ui.components

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*

@Composable
fun BottomNavBar() {
    var selected by remember { mutableStateOf(0) }

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
            icon = { Icon(Icons.Default.Person, null) },
            label = { Text("我的") }
        )
    }
}
