package com.example.mynews

import android.app.Application
import com.example.mynews.core.database.dao.HistoryDao
import com.example.mynews.data.history.HistoryRepository

class MyApp : Application() {
    lateinit var historyDao: HistoryDao
        private set

    lateinit var historyRepository: HistoryRepository
        private set

    override fun onCreate() {
        super.onCreate()

        historyDao = HistoryDao(applicationContext)

        historyRepository = HistoryRepository(historyDao)
    }
}