package com.example.mynews.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.news.data.NewsRepository
import com.example.mynews.news.data.FakeNewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: NewsRepository = FakeNewsRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    private var page = 0
    private val pageSize = 10
    private var isLoading = false
    private var isEndReached = false

    init {
        loadFirstPage("推荐")
    }

    fun onTabSelected(tab: String) {
        loadFirstPage(tab)
    }

    fun loadFirstPage(tab: String) {
        viewModelScope.launch {
            page = 0
            isEndReached = false
            isLoading = false

            val firstPage = repo.getNewsList(tab, page, pageSize)

            _uiState.value = MainUiState(
                selectedTab = tab,
                newsList = firstPage
            )
        }
    }

    fun loadNextPage() {
        if (isLoading || isEndReached) return

        isLoading = true
        page += 1

        viewModelScope.launch {
            val newPage =
                repo.getNewsList(_uiState.value.selectedTab, page, pageSize)

            if (newPage.isEmpty()) {
                isEndReached = true
            } else {
                _uiState.value = _uiState.value.copy(
                    newsList = uiState.value.newsList + newPage
                )
            }

            isLoading = false
        }
    }
}