package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    val index by remember {mutableStateOf(0)}

    var artWorks : Map<Int, Triple<Int, String, String>> = mapOf(
        1 to Triple(R.drawable.beso, stringResource(R.string.beso), stringResource(R.string.gustav_klimt_1909)),
        2 to Triple(R.drawable.perla, stringResource(R.string.la_joven_de_la_perla), stringResource(R.string.johannes_vermeer_1665_1667)),
        3 to Triple(R.drawable.el_aquelarre_goya, stringResource(R.string.francisco_de_goya), stringResource(R.string.el_aquelarre_1798)),
        4 to Triple(R.drawable.meninas, stringResource(R.string.las_meninas), stringResource(R.string.diego_velazquez_1656)),
        5 to Triple(R.drawable.naturaleza_muerta_remedios_varo, stringResource(R.string.naturaleza_muerta_resucitando), stringResource(R.string.remedios_varo))
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp).fillMaxSize()) {
        Row {
            Box (Modifier.height(600.dp)) {
                Image(
                    painter = painterResource(R.drawable.androidparty),
                    contentDescription = "",
                    modifier = Modifier.padding(5.dp)

                )
            }
        }

        Row (modifier = Modifier.padding(5.dp),) {
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = artWorks[index].second, modifier = Modifier.padding(1.dp), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = stringResource(R.string.artwork_artist_year), modifier = Modifier.padding(1.dp))
            }
        }
        Row (modifier = Modifier.padding(5.dp)) {
            Button(onClick = {/*Previous*/ }) { Text(text = stringResource(R.string.previous), Modifier.padding(5.dp)) }
            Spacer (Modifier.width(10.dp))
            Button(onClick = {/*Next*/ }) { Text(text = stringResource(R.string.next), Modifier.padding(5.dp)) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}

