package com.example.mynews.news.data

import com.example.mynews.news.model.News
import com.example.mynews.news.model.NewsType

object FakeNewsSource {

    fun getNewsListForTab(tab: String): List<News> {
        return when (tab) {
            "推荐" -> recommendNews()
            "热榜" -> hotNews()
            else -> recommendNews()
        }
    }

    private fun recommendNews() = listOf(
        News(
            id = "1",
            title = "我国实现载人航天重大突破",
            source = "央视新闻",
            commentCount = 8800,
            time = "1小时前",
            images = listOf("https://picsum.photos/300/200"),
            type = NewsType.SingleImage
        ),
        News(
            id = "2",
            title = "专家：未来10年AI将深刻改变生活",
            source = "科技日报",
            commentCount = 2300,
            time = "2小时前",
            images = listOf(
                "https://picsum.photos/300/200",
                "https://picsum.photos/300/201",
                "https://picsum.photos/300/202"
            ),
            type = NewsType.MultiImage
        ),
        News(
            id = "3",
            title = "冬季养生，这些知识要了解",
            source = "人民日报",
            commentCount = 1200,
            time = "3小时前",
            type = NewsType.PureText
        )
    )

    private fun hotNews() = listOf(
        News(
            id = "4",
            title = "全球多地发生自然异常现象",
            source = "环球时报",
            commentCount = 6000,
            time = "30分钟前",
            images = listOf("https://picsum.photos/300/204"),
            type = NewsType.SingleImage
        )
    )
}