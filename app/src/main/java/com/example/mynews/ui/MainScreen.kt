package com.example.mynews.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mynews.news.data.FakeNewsRepository
import com.example.mynews.news.ui.NewsList
import com.example.mynews.ui.components.BottomNavBar
import com.example.mynews.ui.components.TabsSection
import com.example.mynews.ui.components.TopBar

@Composable
fun MainScreen(){
    var selectedTab by remember { mutableStateOf("推荐") }
    val newsList by remember(selectedTab) {
        mutableStateOf(FakeNewsRepository.getNewsListForTab(selectedTab))
    }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {BottomNavBar()},
    ) {
        padding->
        Column(
            modifier= Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            TabsSection(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
            NewsList(newsList)
        }
    }
}