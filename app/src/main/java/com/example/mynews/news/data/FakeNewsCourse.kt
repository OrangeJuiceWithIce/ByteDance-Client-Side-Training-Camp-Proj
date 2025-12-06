package com.example.mynews.news.data

import com.example.mynews.news.model.News
import com.example.mynews.news.model.NewsType

object FakeNewsSource {

    fun getNewsListForTab(tab: String): List<News> {
        return when (tab) {
            "推荐" -> recommendNews
            "热榜" -> hotNews
            else -> recommendNews
        }
    }

    private val recommendNews = List(30) { index ->
        when (index % 3) {
            0 -> News(
                id = "rec_single_$index",
                title = "专家：AI 正在重塑全球竞争格局（第 $index 条）",
                source = "科技日报",
                commentCount = (1000..9000).random(),
                time = "${(1..12).random()} 分钟前",
                images = listOf("https://picsum.photos/seed/recs$index/400/250"),
                type = NewsType.SingleImage
            )

            1 -> News(
                id = "rec_multi_$index",
                title = "城市治理现代化取得新突破（第 $index 条）",
                source = "新华网",
                commentCount = (300..2000).random(),
                time = "${(1..5).random()} 小时前",
                images = listOf(
                    "https://picsum.photos/seed/recm${index}a/400/300",
                    "https://picsum.photos/seed/recm${index}b/400/300",
                    "https://picsum.photos/seed/recm${index}c/400/300"
                ),
                type = NewsType.MultiImage
            )

            else -> News(
                id = "rec_text_$index",
                title = "冬季健康指南：提高免疫力的 5 种方法（第 $index 条）",
                source = "人民日报",
                commentCount = (10..300).random(),
                time = "${(1..23).random()} 小时前",
                type = NewsType.PureText
            )
        }
    }

    private val hotNews = List(20) { index ->
        when (index % 3) {
            0 -> News(
                id = "hot_single_$index",
                title = "全球经济形势出现新变化（第 $index 条）",
                source = "央视新闻",
                commentCount = (2000..15000).random(),
                time = "${(1..50).random()} 分钟前",
                images = listOf("https://picsum.photos/seed/hots$index/500/300"),
                type = NewsType.SingleImage
            )

            1 -> News(
                id = "hot_multi_$index",
                title = "本周多地迎来大范围降温（第 $index 条）",
                source = "中国气象台",
                commentCount = (800..6000).random(),
                time = "${(1..8).random()} 小时前",
                images = listOf(
                    "https://picsum.photos/seed/hotm${index}a/450/280",
                    "https://picsum.photos/seed/hotm${index}b/450/280",
                    "https://picsum.photos/seed/hotm${index}c/450/280"
                ),
                type = NewsType.MultiImage
            )

            else -> News(
                id = "hot_text_$index",
                title = "年轻人为什么更注重健康生活方式？（第 $index 条）",
                source = "光明日报",
                commentCount = (50..400).random(),
                time = "${(1..12).random()} 小时前",
                type = NewsType.PureText
            )
        }
    }
}