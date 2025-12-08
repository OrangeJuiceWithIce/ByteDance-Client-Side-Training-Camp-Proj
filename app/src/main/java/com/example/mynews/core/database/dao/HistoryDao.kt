package com.example.mynews.core.database.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.mynews.core.database.HistoryDatabaseHelper
import com.example.mynews.model.history.HistoryEntry

class HistoryDao(context: Context) {

    private val db = HistoryDatabaseHelper(context).writableDatabase

    fun insert(entity: HistoryEntry) {
        val values = ContentValues().apply {
            put(HistoryDatabaseHelper.COLUMN_NEWS_ID, entity.newsId)
            put(HistoryDatabaseHelper.COLUMN_TITLE, entity.title)
            put(HistoryDatabaseHelper.COLUMN_READ_TIME, entity.readTime)
        }

        db.insertWithOnConflict(
            HistoryDatabaseHelper.TABLE_HISTORY,
            null,
            values,
            SQLiteDatabase.CONFLICT_REPLACE
        )
    }

    fun getAll(): List<HistoryEntry> {
        val cursor = db.rawQuery(
            "SELECT * FROM ${HistoryDatabaseHelper.TABLE_HISTORY} ORDER BY read_time DESC",
            null
        )

        val list = mutableListOf<HistoryEntry>()
        while (cursor.moveToNext()) {
            list.add(
                HistoryEntry(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow(HistoryDatabaseHelper.COLUMN_ID)),
                    newsId = cursor.getString(cursor.getColumnIndexOrThrow(HistoryDatabaseHelper.COLUMN_NEWS_ID)),
                    title = cursor.getString(cursor.getColumnIndexOrThrow(HistoryDatabaseHelper.COLUMN_TITLE)),
                    readTime = cursor.getLong(cursor.getColumnIndexOrThrow(HistoryDatabaseHelper.COLUMN_READ_TIME))
                )
            )
        }
        cursor.close()
        return list
    }

    fun clear() {
        db.execSQL("DELETE FROM ${HistoryDatabaseHelper.TABLE_HISTORY}")
    }
}
