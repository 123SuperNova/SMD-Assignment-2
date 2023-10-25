package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                    Page()
                }
            }
        }
    }
}

@Composable
fun Page(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            val title = stringResource(id = R.string.Compose_Article_Title)
            val description = stringResource(id = R.string.Compose_Article_Description)
            val bodyText = stringResource(id = R.string.Compose_Article_Body)
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = modifier
                    .padding(16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(16.dp)
            )
            Text(
                text = bodyText,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Page()
    }
}