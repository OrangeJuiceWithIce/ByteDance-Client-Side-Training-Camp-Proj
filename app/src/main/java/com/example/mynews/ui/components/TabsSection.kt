package com.example.mynews.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TabsSection() {
    var selectedTab by remember { mutableStateOf(1) }  // 默认选“推荐”

    val tabs = listOf("关注", "推荐", "热榜", "新时代", "小视频", "视频")

    ScrollableTabRow(
        selectedTabIndex = selectedTab,
        edgePadding = 0.dp,
        modifier = Modifier.padding(top = 5.dp),
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTab])
                    .height(3.dp)
                    .padding(horizontal = 30.dp),
                color = Color(0xFFFF4D4F)
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTab == index,
                onClick = { selectedTab = index },
                text = { Text(title) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewTabSection(){
    TabsSection()
}