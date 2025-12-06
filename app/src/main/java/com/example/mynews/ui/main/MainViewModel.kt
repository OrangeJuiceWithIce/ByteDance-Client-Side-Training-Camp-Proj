package com.example.mynews.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.news.data.FakeNewsRepository
import com.example.mynews.news.data.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: NewsRepository = FakeNewsRepository()
): ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        loadNewsForTab("推荐")
    }

    fun onTabSelected(tab: String) {
        _uiState.value = _uiState.value.copy(selectedTab = tab)
        loadNewsForTab(tab)
    }

    private fun loadNewsForTab(tab: String) {
        viewModelScope.launch {
            val news = repo.getNewsListForTab(tab)
            _uiState.value = _uiState.value.copy(newsList = news)
        }
    }
}
