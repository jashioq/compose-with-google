package com.example.composewithgoogle8

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composewithgoogle8.ui.theme.ComposeWithGoogle8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithGoogle8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LemonadeApp() {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Lemonade app",
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Yellow
            )
        )
        LemonadeProcess(modifier = Modifier)
    }
}

@Composable
fun LemonadeProcess(modifier: Modifier) {

    var step by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    when (step) {
        1 -> LemonTextAndImage(
            textResourceId = R.string.tap_tree,
            imageResourceId = R.drawable.lemon_tree,
            imageContentDescriptionId = R.string.lemon_tree,
            onImageClick = {
                step = 2
                squeezeCount = (2..5).random()
            }
        )
        2 -> LemonTextAndImage(
            textResourceId = R.string.tap_lemon,
            imageResourceId = R.drawable.lemon_squeeze,
            imageContentDescriptionId = R.string.squeeze_the_lemon,
            onImageClick = {
                squeezeCount--
                if (squeezeCount == 0) {
                    step = 3
                }
            }
        )
        3 -> LemonTextAndImage(
            textResourceId = R.string.drink_lemonade,
            imageResourceId = R.drawable.lemon_drink,
            imageContentDescriptionId = R.string.drink_lemonade,
            onImageClick = {
                step = 4
            }
        )
        else -> LemonTextAndImage(
            textResourceId = R.string.empty_glass,
            imageResourceId = R.drawable.lemon_restart,
            imageContentDescriptionId = R.string.restart,
            onImageClick = {
                step = 1
            }
        )
    }
}

@Composable
fun LemonTextAndImage(
    textResourceId: Int,
    imageResourceId: Int,
    imageContentDescriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Button(onClick = onImageClick ) {
            Image(
                painter = painterResource(imageResourceId),
                contentDescription = stringResource(imageContentDescriptionId),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResourceId),
            fontSize = 18.sp
        )
    }
}
