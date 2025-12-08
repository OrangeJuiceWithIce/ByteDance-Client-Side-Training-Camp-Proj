package com.example.mynews.core.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class HistoryDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "history.db"
        private const val DATABASE_VERSION = 2

        const val TABLE_HISTORY = "history"
        const val COLUMN_ID="id"
        const val COLUMN_NEWS_ID = "newsId"
        const val COLUMN_TITLE = "title"
        const val COLUMN_READ_TIME = "read_time"

        private const val TABLE_CREATE = """
            CREATE TABLE $TABLE_HISTORY (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NEWS_ID TEXT UNIQUE,
                $COLUMN_TITLE TEXT NOT NULL,
                $COLUMN_READ_TIME LONG
            );
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.w(
            HistoryDatabaseHelper::class.java.name,
            "Upgrading database from version $oldVersion to $newVersion, which will destroy all old data"
        )

        db.execSQL("DROP TABLE IF EXISTS $TABLE_HISTORY")
        onCreate(db)
    }
}