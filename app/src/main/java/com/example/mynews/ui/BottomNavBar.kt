package com.example.mynews.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.mynews.model.BottomNavItem

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,//参考BottomNavConfig
    selectedIndex: Int,//默认选中的item
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.index == selectedIndex,
                onClick = { onItemSelected(item.index) },
                icon = { Icon(item.icon, null) },
                label = { Text(item.label) }
            )
        }
    }
}