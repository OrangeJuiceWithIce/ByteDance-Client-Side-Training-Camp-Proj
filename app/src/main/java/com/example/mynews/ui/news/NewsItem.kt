package com.example.mynews.ui.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mynews.model.news.News
import com.example.mynews.model.news.NewsType

@Composable
fun NewsItem(
    news: News,
    onClick:()-> Unit
) {

    Column(modifier = Modifier
        .padding(12.dp)
        .clickable { onClick() }
    ) {

        when (news.type) {
            NewsType.SingleImage -> SingleImageLayout(news)
            NewsType.MultiImage -> MultiImageLayout(news)
            NewsType.PureText -> PureTextLayout(news)
        }
    }
}

@Composable
fun PureTextLayout(news: News){
    Text(
        text = news.title,
        fontSize = 16.sp,
        color = Color.Black,
        maxLines = 2
    )

    Text(
        text = "${news.source} · ${news.commentCount}评论 · ${news.time}",
        fontSize = 12.sp,
        color = Color.Gray.copy(alpha = 0.8f)
    )
}
@Composable
fun SingleImageLayout(news: News) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = news.title,
                fontSize = 16.sp,
                color = Color.Black,
                maxLines = 2
            )

            Text(
                text = "${news.source} · ${news.commentCount}评论 · ${news.time}",
                fontSize = 12.sp,
                color = Color.Gray.copy(alpha = 0.8f)
            )
        }

        AsyncImage(
            model = news.images.first(),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(4f/3f)
                .fillMaxHeight(),
        )
    }
}


@Composable
fun MultiImageLayout(news: News) {
    Column {
        Text(
            text = news.title,
            fontSize = 16.sp,
            color = Color.Black,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            news.images.forEach {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(4f/3f)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${news.source} · ${news.commentCount}评论 · ${news.time}",
            fontSize = 12.sp,
            color = Color.Gray.copy(alpha = 0.8f)
        )
    }
}
