package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun AppBar(cityname: String, modifier: Modifier = Modifier) {
    val menui = painterResource(R.drawable.menubtn)
    val searchi = painterResource(R.drawable.searchbtn)
    val tooli = painterResource(R.drawable.tool)
    val barColor =  Color.White
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ){
            Image(
                painter = menui,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(barColor),
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = cityname,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
        ){
            Image(
                painter = searchi,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(barColor),
                modifier = Modifier
                    .size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = tooli,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(barColor),
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}

    @Composable
fun DayTempBar(temp: String, weather: String, date: String, time: String, modifier: Modifier = Modifier) {

        Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(8.dp)
    ){
        Row (
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = temp,
                fontSize = 54.sp,
                color = Color.White,
            )
            Column (

                modifier = Modifier
                    .padding(8.dp)
            ){
                Text(
                    text = "°C",
                    fontSize = 22.sp,
                    color = Color.Yellow
                )
                Text(
                    text = weather,
                    fontSize = 22.sp,
                    color = Color.Yellow
                )
            }
        }
        Column (
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = date,
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = time,
                fontSize = 24.sp,
                color = Color.Cyan
            )
        }
    }
}

    @Composable
fun DayTempCard(day: String, temp: String, image: Painter, showBorder: Boolean, modifier: Modifier = Modifier){
    val textColor = if (showBorder) Color.Blue.copy(alpha = 0.6f) else Color.Gray

    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .then(
            if (showBorder) Modifier else Modifier.background(Color.Gray.copy(alpha = 0.2f))
        )
            .padding(8.dp)
    ) {
        Text(
            text = day,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = textColor,
            modifier = Modifier
        )
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            //colorFilter = ColorFilter.tint(textColor),
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            text = temp,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = textColor,
            modifier = Modifier
        )
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        val image = painterResource(R.drawable.weatherbgimage)
        Box(
            modifier = modifier
                .weight(0.7f)
        )
        {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column (
                verticalArrangement = Arrangement.Top,
                modifier = modifier
            ) {
                AppBar(
                    cityname = "Lahore",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                DayTempBar(
                    temp = "32",
                    weather = "Sunny",
                    date = "13 FEB, MON",
                    time = "02:00 PM",
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
        Row (
            modifier = modifier
                .weight(0.3f)
                .fillMaxWidth()
        )
        {
            DayTempCard(
                day = "MON",
                temp = "32",
                image = painterResource(R.drawable.sunny),
                showBorder = true,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
            DayTempCard(
                day = "TUE",
                temp = "31",
                image = painterResource(R.drawable.partially_cloudy),
                showBorder = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
            DayTempCard(
                day = "WED",
                temp = "30",
                image = painterResource(R.drawable.cloudy),
                showBorder = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
            DayTempCard(
                day = "THU",
                temp = "33",
                image = painterResource(R.drawable.sunny),
                showBorder = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
            DayTempCard(
                day = "FRI",
                temp = "35",
                image = painterResource(R.drawable.sunny),
                showBorder = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherAppTheme {
        MainPage()
    }
}