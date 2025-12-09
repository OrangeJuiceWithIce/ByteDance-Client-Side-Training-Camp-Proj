package com.example.mynews.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//时间Long->yyyy-MM-dd
fun formatTimestamp(ts: Long): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
    return sdf.format(Date(ts))
}