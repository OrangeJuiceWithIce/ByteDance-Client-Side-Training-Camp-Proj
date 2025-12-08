package com.example.mynews.ui.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynews.BottomNavConfig
import com.example.mynews.handleBottomBarClick
import com.example.mynews.ui.BottomNavBar
import com.example.mynews.ui.history.components.HistoryList
import com.example.mynews.ui.history.components.HistoryTopBar
import com.example.mynews.viewmodel.HistoryViewModel

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel = viewModel()
) {
    val context = LocalContext.current
    val list = viewModel.historyList

    Scaffold(
        topBar = { HistoryTopBar(
            onDeleteAll = { viewModel.deleteAllHistory()}
        ) },
        bottomBar = {
            BottomNavBar(
                items = BottomNavConfig.items,
                selectedIndex = 4,
                onItemSelected = {
                    index -> handleBottomBarClick(context, index)
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {
            HistoryList(
                history = list,
                onItemClick = {}
            )
        }
    }
}