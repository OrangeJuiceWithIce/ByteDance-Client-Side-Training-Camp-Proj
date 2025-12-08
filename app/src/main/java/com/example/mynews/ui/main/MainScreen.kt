package com.example.mynews.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynews.BottomNavConfig
import com.example.mynews.handleBottomBarClick
import com.example.mynews.ui.news.NewsList
import com.example.mynews.ui.BottomNavBar
import com.example.mynews.ui.main.components.TabsSection
import com.example.mynews.ui.main.components.TopBar
import com.example.mynews.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context= LocalContext.current
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavBar(
            items = BottomNavConfig.items,
            selectedIndex = 2,
            onItemSelected = {
                index-> handleBottomBarClick(context, index)
            }
        ) }
    ) { padding ->

        PullToRefreshBox(
            isRefreshing = uiState.isRefreshing,
            onRefresh = { viewModel.refresh() },
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            Column(Modifier.fillMaxSize()) {

                TabsSection(
                    selectedTab = uiState.selectedTab,
                    onTabSelected = { viewModel.onTabSelected(it) }
                )

                NewsList(
                    news = uiState.newsList,
                    onLoadMore = { viewModel.loadNextPage(context) },
                    onItemClick = {news -> viewModel.onNewsClicked(news)}
                )
            }
        }
    }
}