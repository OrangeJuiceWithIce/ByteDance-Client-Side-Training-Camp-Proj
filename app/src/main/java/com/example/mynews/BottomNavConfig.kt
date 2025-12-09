package com.example.mynews

import android.content.Context
import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import com.example.mynews.model.BottomNavItem

//用于配置底部导航栏的选项和icon
object BottomNavConfig{
    val items = listOf(
        BottomNavItem(0, "首页", Icons.Default.Home),
        BottomNavItem(1, "视频", Icons.Default.PlayArrow),
        BottomNavItem(2, "搜索", Icons.Default.Search),
        BottomNavItem(3, "任务", Icons.Default.DateRange),
        BottomNavItem(4, "我的", Icons.Default.Person)
    )
}

fun handleBottomBarClick(
    context: Context,
    index: Int
) {
    when (index) {
        2 -> context.startActivity(Intent(context, MainActivity::class.java))
        4 -> context.startActivity(Intent(context, HistoryActivity::class.java))
    }
}