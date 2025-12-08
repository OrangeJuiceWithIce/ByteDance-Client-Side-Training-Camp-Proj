package com.example.mynews.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mynews.MyApp
import com.example.mynews.model.history.HistoryEntry

class HistoryViewModel(
    application: Application
) :AndroidViewModel(application) {
    private val historyRepo = (application as MyApp).historyRepository
    val historyList: List<HistoryEntry> = historyRepo.getHistory()
}