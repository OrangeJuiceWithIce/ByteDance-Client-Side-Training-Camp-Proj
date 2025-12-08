package com.example.mynews.ui.main.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TabsSection(
    tabs: List<String> = listOf("关注", "推荐", "热榜", "新时代", "小视频", "视频"),
    selectedTab: String,
    onTabSelected: (String) -> Unit
) {
    val selectedIndex = tabs.indexOf(selectedTab).coerceAtLeast(0)

    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 0.dp,
        modifier = Modifier.padding(top = 5.dp),
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex])
                    .height(3.dp)
                    .padding(horizontal = 30.dp),
                color = Color(0xFFFF4D4F)
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedIndex == index,
                onClick = { onTabSelected(title) },
                text = { Text(title) }
            )
        }
    }
}