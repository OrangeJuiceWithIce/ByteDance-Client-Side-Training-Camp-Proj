package com.example.mynews.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.MyApp
import com.example.mynews.model.history.HistoryEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryViewModel(
    application: Application
) :AndroidViewModel(application) {
    private val historyRepo = (application as MyApp).historyRepository
    var historyList by mutableStateOf(listOf<HistoryEntry>())
        private set

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                historyRepo.getHistory()
            }
            historyList = list
        }
    }

    fun deleteAllHistory(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                historyRepo.clearHistory()
            }
            historyList = emptyList()
        }
    }
}