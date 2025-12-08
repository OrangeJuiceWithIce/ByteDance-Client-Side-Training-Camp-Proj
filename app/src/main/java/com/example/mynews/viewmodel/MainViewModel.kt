package com.example.mynews.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.mynews.MyApp
import com.example.mynews.model.main.MainUiState
import com.example.mynews.data.news.FakeNewsRepository
import com.example.mynews.data.news.NewsRepository
import com.example.mynews.model.news.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val newsRepo: NewsRepository = FakeNewsRepository()
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    private val historyRepo = (application as MyApp).historyRepository
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

            val firstPage = newsRepo.getNewsList(tab, page, pageSize)

            _uiState.value = MainUiState(
                selectedTab = tab,
                newsList = firstPage
            )
        }
    }

    fun loadNextPage(context: Context) {
        if (isLoading || isEndReached) return

        isLoading = true
        page += 1

        viewModelScope.launch {
            val newPage =
                newsRepo.getNewsList(_uiState.value.selectedTab, page, pageSize)

            if (newPage.isEmpty()) {
                isEndReached = true
            } else {
                launch(Dispatchers.IO) {
                    newPage.forEach { news ->
                        news.images.forEach { url ->
                            preloadImage(context, url)
                        }
                    }
                }

                _uiState.value = _uiState.value.copy(
                    newsList = uiState.value.newsList + newPage
                )
            }

            isLoading = false
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)

            delay(800)

            val tab = _uiState.value.selectedTab

            val allPages = (0..5).toMutableList()
            allPages.remove(page)
            val randomPage = allPages.random()
            page = randomPage
            isEndReached = false
            isLoading = false

            val randomPageData = newsRepo.getNewsList(tab, randomPage, pageSize)

            _uiState.value = _uiState.value.copy(
                newsList = randomPageData,
                isRefreshing = false
            )
        }
    }


    private fun preloadImage(context: Context, url: String) {
        if (url.isBlank()) return

        val request = ImageRequest.Builder(context)
            .data(url)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()

        context.imageLoader.enqueue(request)
    }

    fun onNewsClicked(news: News) {
        viewModelScope.launch(Dispatchers.IO) {
            historyRepo.recordHistory(news)
        }
    }
}