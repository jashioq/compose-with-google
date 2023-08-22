package com.example.composewithgoogle6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.composewithgoogle6.ui.theme.ComposeWithGoogle6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithGoogle6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Card() {
    ComposeWithGoogle6Theme {
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color("#ffe7b3".toColorInt()))
        ) {
            ProfileInfo(
                name = stringResource(R.string.name),
                title = stringResource(R.string.title)
            )
            ContactInfo(
                phoneNumber = stringResource(R.string.phone_number),
                email = stringResource(R.string.email)
            )
        }

    }
}

@Composable
fun ProfileInfo (name: String, title: String) {
    val image = painterResource(R.drawable.android_logo)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(232.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp, 16.dp, 0.dp, 12.dp)
        )
        Text(
            text = title,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContactInfo(phoneNumber: String, email: String) {
    Column {
        Row (
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 12.dp)
        ) {
            Icon(Icons.Rounded.Call, contentDescription = "Phone number")
            Text(
                text = phoneNumber,
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
            )
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = "Email address")
            Text(
                text = email,
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Card()
}