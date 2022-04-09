package com.ksmandroid.workshopjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ksmandroid.workshopjetpackcompose.repository.NewsRepository
import com.ksmandroid.workshopjetpackcompose.ui.theme.WorkshopjetpackcomposeTheme
import com.ksmandroid.workshopjetpackcompose.util.DateFormatUtil

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("extra_id", -1)
        val news = NewsRepository.getAll().first { it.id == id }

        setContent {
            WorkshopjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            NewsImage(news.imageUrl)
                            NewsTitle(news.title)
                            NewsAuthorAndDate(author = news.author, date = news.date)
                            NewsDescription(description = news.description)
                        }

                        // FloatingActionButton
                        var isFavourite by remember { mutableStateOf(false) }

                        FloatingActionButton(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp),
                            onClick = {
                                isFavourite = !isFavourite
                            }
                        ) {
                            Image(
                                modifier = Modifier,
                                painter = painterResource(
                                    id = if (isFavourite)
                                        R.drawable.ic_favorite_active
                                    else
                                        R.drawable.ic_favorite_inactive
                                ),
                                colorFilter = ColorFilter.tint(Color.Red),
                                contentDescription = "Favourite Button Icon"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NewsImage(imageUrl: String) {
    Image(
        modifier = Modifier.aspectRatio(16 / 9f),
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Content Image",
        contentScale = ContentScale.Crop
    )
}

@Composable
fun NewsTitle(title: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            // Dots at the end of the text
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun NewsAuthorAndDate(author: String, date: String) {
    Row(
        modifier = Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Author's name
        Text(
            text = author,
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
            text = DateFormatUtil.formatDate(date),
            fontSize = 10.sp
        )
    }
}

@Composable
fun NewsDescription(description: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
    ) {
        Column() {
            Text(
                text = description,
                fontSize = 14.sp
            )
            Text(
                text = description,
                fontSize = 14.sp
            )
            Text(
                text = description,
                fontSize = 14.sp
            )
            Text(
                text = description,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}
