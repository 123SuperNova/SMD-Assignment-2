package com.example.task_2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.task_2_2.ui.theme.Task22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task22Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun CityCards(cityname: String, humidity: String, tempWeather:String, selected: Boolean, modifier: Modifier = Modifier) {
    val textColor1 = if (selected) Color.White else Color.Gray
    val textColor2 = if (selected) Color.Red else Color.Blue.copy(alpha = 0.7f)

    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .then(
                if (selected) Modifier.background(Color.Blue.copy(alpha = 0.7f)) else Modifier
            )
            .padding(16.dp)
            .padding(top = 20.dp, bottom = 20.dp)

    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = cityname,
                fontWeight = FontWeight.Bold,
                color = textColor1,
                fontSize = 26.sp,
                modifier = Modifier
            )
            Text(
                text = humidity,
                color = Color.Gray,
                fontSize = 20.sp,
                modifier = Modifier
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
        )
        {
            Text(
                text = tempWeather,
                fontWeight = FontWeight.Bold,
                color = textColor2,
                fontSize = 20.sp,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .weight(0.45f)
                .fillMaxSize()
        )
        {
            Row(
                modifier = modifier
                    .fillMaxSize()
            )
            {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .weight(0.7f)
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    val backarrow = painterResource(R.drawable.arrow)
                    val dotsico = painterResource(R.drawable.twodots)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier
                            .weight(0.20f)
                            .fillMaxWidth()
                    ){
                        Row (
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                        ){
                            Image(
                                painter = backarrow,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(Color.Gray),
                                modifier = Modifier
                                    .size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(
                                text = "Locations",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00008B),
                                fontSize = 20.sp,
                            )
                        }
                        Row (
                            horizontalArrangement = Arrangement.End,
                            modifier = modifier
                                .fillMaxWidth()
                        ){
                            Image(
                                painter = dotsico,
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(Color.Gray),
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(0.5f)
                    ){
                        val message = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 18.sp)) {
                                append("You are currently getting results for popular places in ")
                            }
                            withStyle(style = SpanStyle(color = Color.Red, fontSize = 18.sp)) {
                                append("Pakistan")
                            }
                        }
                        Text(
                            text= message
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(0.25f)
                    ){
                        Text(
                            text= "Choose place",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Blue.copy(alpha = 0.7f),
                            modifier = Modifier
                                .background(
                                    Color.LightGray.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(26.dp)
                                )
                                .padding(16.dp)
                        )
                    }
                }
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .weight(0.3f)
                        .fillMaxSize()
                        .background(Color.LightGray)
                ){
                    val addsign = painterResource(R.drawable.plussign)
                    Image(
                        painter = addsign,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(Color(0xFF00008B)),
                        modifier = Modifier
                            .size(28.dp)
                    )
                    Text(
                        text = "ADD PLACE",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00008B),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
        Column (
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .weight(0.65f)
                .fillMaxWidth()
        ){
            CityCards(
                cityname = "Lahore",
                humidity = "51%",
                tempWeather = "32, Sunny",
                selected = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            CityCards(
                cityname = "Islamabad",
                humidity = "35%",
                tempWeather = "28, Cloudy",
                selected = false,
                modifier = Modifier
                    .fillMaxWidth()
            )
            CityCards(
                cityname = "Lahore",
                humidity = "51%",
                tempWeather = "32, Sunny",
                selected = false,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task22Theme {
        MainMenu()
    }
}