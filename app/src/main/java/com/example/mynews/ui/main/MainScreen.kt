package com.example.mynews.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mynews.news.ui.NewsList
import com.example.mynews.ui.components.BottomNavBar
import com.example.mynews.ui.components.TabsSection
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynews.ui.components.TopBar

@Composable
fun MainScreen(
    viewModel: MainViewModel= viewModel()
){
    val uiState by viewModel.uiState.collectAsState()

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
                selectedTab = uiState.selectedTab,
                onTabSelected = { viewModel.onTabSelected(it)}
            )
            NewsList(uiState.newsList)
        }
    }
}