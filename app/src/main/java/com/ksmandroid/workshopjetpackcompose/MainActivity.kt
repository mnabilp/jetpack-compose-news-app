package com.ksmandroid.workshopjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ksmandroid.workshopjetpackcompose.model.News
import com.ksmandroid.workshopjetpackcompose.repository.NewsRepository
import com.ksmandroid.workshopjetpackcompose.ui.theme.WorkshopjetpackcomposeTheme
import com.ksmandroid.workshopjetpackcompose.util.DateFormatUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkshopjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {

                    val newsList = NewsRepository.getAll()

                    Column(modifier = Modifier) {
                        Header()
                        NewsList(newsList = newsList)
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 4.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(
                    width = 150.dp,
                    height = 60.dp
                ),
            painter = rememberAsyncImagePainter(model = "https://static.wikia.nocookie.net/logopedia/images/7/75/Google_News_2015.png/revision/latest?cb=20160220081235"),
            contentDescription = "Logo"
        )
    }
}

@Composable
fun NewsList(newsList: List<News>) {
    LazyColumn {
        items(newsList.size) {
            // News Row
            NewsListItem(newsList[it])
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(1.dp),
                color = Color.Gray
            )
        }

    }
}

@Composable
fun NewsListItem(news: News) {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 16.dp
            )
            .height(IntrinsicSize.Min)
            .clickable{
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("extra_id", news.id)
                context.startActivity(intent)
            }
    ) {
        // Content Title and Description
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                )
        ) {
            Text(
                text = news.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                // Dots at the end of the text
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(28.dp))
            // Content author and date
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Author's name
                Text(
                    text = news.author,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                // Dot
                Canvas(
                    modifier = Modifier
                        .size(4.dp)
                ) {
                    drawCircle(Color.Gray)
                }
                Spacer(modifier = Modifier.width(4.dp))
                // Date and time
                Text(
                    text = DateFormatUtil.formatDate(news.date),
                    fontSize = 10.sp
                )
            }
        }
        // Content Image
        Image(
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
                .clip(RoundedCornerShape(10.dp)),
            painter = rememberAsyncImagePainter(news.imageUrl),
            contentDescription = "Content Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkshopjetpackcomposeTheme {

    }
}