package com.example.composewithgoogle5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composewithgoogle5.ui.theme.ComposeWithGoogle5Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(firstTitle: String, secondTitle: String, thirdTitle: String,
                    fourthTitle: String, firstText: String, secondText: String, thirdText: String,
                    fourthText: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
//            .fillMaxSize()
    ) {
        Column {
            Text(
                text = "1",
                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .width(50.dp)
//                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "2"
            )
        }
        Column {
            Row {
                Text(
                    text = "."
                )
            }
            Row {
                Text(
                    text = "."
                )
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