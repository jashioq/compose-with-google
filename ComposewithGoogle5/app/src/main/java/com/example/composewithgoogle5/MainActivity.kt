package com.example.composewithgoogle5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composewithgoogle5.ui.theme.ComposeWithGoogle5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithGoogle5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrant(
                        firstTitle = "Text composable",
                        secondTitle = "Image composable",
                        thirdTitle = "Row composable",
                        fourthTitle = "Column composable",
                        firstText = "Displays text and follows the recommended Material Design guidelines.",
                        secondText = "Creates a composable that lays out and draws a given Painter class object.",
                        thirdText = "A layout composable that places its children in a horizontal sequence.",
                        fourthText = "A layout composable that places its children in a vertical sequence.",
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(firstTitle: String, secondTitle: String, thirdTitle: String,
                    fourthTitle: String, firstText: String, secondText: String, thirdText: String,
                    fourthText: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row (
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp)
            ) {
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = firstTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    )
                    Text(
                        text = firstText,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
            Box (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFD0BCFF))
                    .padding(16.dp)
            ) {
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = secondTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    )
                    Text(
                        text = secondText,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
        Row (
            modifier = Modifier
                .weight(1f)
        ) {
            Box (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFB69DF8))
                    .padding(16.dp)
            ) {
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = thirdTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    )
                    Text(
                        text = thirdText,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
            Box (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFF6EDFF))
                    .padding(16.dp)
            ) {
                Column (
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                ) {
                    Text(
                        text = fourthTitle,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(0.dp, 0.dp, 0.dp, 16.dp)
                    )
                    Text(
                        text = fourthText,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeWithGoogle5Theme {
        ComposeQuadrant(
            firstTitle = "Text composable",
            secondTitle = "Image composable",
            thirdTitle = "Row composable",
            fourthTitle = "Column composable",
            firstText = "Displays text and follows the recommended Material Design guidelines.",
            secondText = "Creates a composable that lays out and draws a given Painter class object.",
            thirdText = "A layout composable that places its children in a horizontal sequence.",
            fourthText = "A layout composable that places its children in a vertical sequence.",
        )
    }
}