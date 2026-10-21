package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.models.Day

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DaysApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DaysApp( modifier: Modifier = Modifier) {

}

fun DayCard(day: Day, modifier: Modifier = Modifier){



}

@Preview(showBackground = true)
@Composable
fun DayCardPreview() {
    ProyectoTheme {
        DayCard(Day(R.drawable.androidparty, R.string.DaysApp, R.string.One))
    }
}

@Preview(showBackground = true)
@Composable
fun DayAppPreview() {
    ProyectoTheme {
        DaysApp()
    }
}