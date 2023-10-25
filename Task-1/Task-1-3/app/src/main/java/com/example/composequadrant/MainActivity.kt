package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposableQCard(title: String, description: String, backColor: Color, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backColor)
            .padding(16.dp)
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
        )
    }
}

@Composable
fun ComposableQuadrant(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        //verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()

    ){
        Row (
            //horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(1f)
        ) {
            ComposableQCard(
                title = stringResource(id = R.string.TC_Title),
                description = stringResource(id = R.string.TC_Description),
                backColor = Color(ContextCompat.getColor(context, R.color.TopLeft)),
                modifier = Modifier
                    .weight(1f)
            )
            ComposableQCard(
                title = stringResource(id = R.string.IC_Title),
                description = stringResource(id = R.string.IC_Description),
                backColor = Color(ContextCompat.getColor(context, R.color.TopRight)),
                modifier = Modifier
                    .weight(1f)
            )
        }
        Row (
            //horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.weight(1f)
        ) {
            ComposableQCard(
                title = stringResource(id = R.string.RC_Title),
                description = stringResource(id = R.string.RC_Description),
                backColor = Color(ContextCompat.getColor(context, R.color.BottomLeft)),
                modifier = Modifier
                    .weight(1f)
            )
            ComposableQCard(
                title = stringResource(id = R.string.CC_Title),
                description = stringResource(id = R.string.CC_Description),
                backColor = Color(ContextCompat.getColor(context, R.color.BottomRight)),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposableQuadrant()
    }
}