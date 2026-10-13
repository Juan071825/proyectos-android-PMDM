package com.example.cuadranteCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cuadranteCompose.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column(modifier.fillMaxSize()) {
        Row(modifier.weight(1f).fillMaxHeight()) {
            Box(modifier.weight(1f).fillMaxHeight().background(Color(0xFFEADDFF))) {
                Column {
                    Text(
                        text = "Text composable"
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines."
                    )
                }

            }

            Box(modifier.weight(1f).fillMaxHeight().background(Color(0xFFD0BCFF))) {
                Column {
                    Text(
                        text = "Image composable"
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object."
                    )
                }
            }
        }

        Row(modifier.weight(1f).fillMaxHeight()) {

                Box(modifier.weight(1f).fillMaxHeight().background(Color(0xFFD0BCFF))) {
                    Column {
                    Text(
                        text = "Row composable"
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence."
                    )
                    }
                }
                Box(modifier.weight(1f).fillMaxHeight().background(Color(0xFFEADDFF))) {
                    Column {
                        Text(
                            text = "Column composable"
                        )
                        Text(
                            text = "A layout composable that places its children in a vertical sequence."
                        )
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}