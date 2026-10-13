package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import kotlin.collections.listOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier.padding(innerPadding),
                        listOf<Artwork>(
                            Artwork(R.drawable.meninas, R.string.las_meninas_1656, R.string.diego_velazquez),
                            Artwork(R.drawable.beso, R.string.el_beso_1908_1909, R.string.gustav_klimt),
                            Artwork(R.drawable.el_aquelarre_goya, R.string.el_aquelarre_1789_1798, R.string.francisco_de_goya),
                            Artwork(R.drawable.perla, R.string.la_joven_de_la_perla_1665, R.string.johannes_vermeer),
                            Artwork(R.drawable.naturaleza_muerta_remedios_varo, R.string.naturaleza_muerta_resucitando_1963, R.string.remedios_varos)
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun ArtSpace(modifier: Modifier = Modifier, artworks : List<Artwork>) {

    var index by rememberSaveable { mutableStateOf(0) }
    val actual = artworks[index]
    Box (modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp).fillMaxSize()) {
            Row {
                Box(modifier = Modifier.fillMaxWidth().height(400.dp), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(actual.imageRes),
                        contentDescription = "",
                        modifier = Modifier.padding(5.dp).fillMaxSize()
                    )
                }
            }

            Row (modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFCFC9C8)), horizontalArrangement = Arrangement.Center) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(actual.title), modifier = Modifier.padding(1.dp), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(actual.artistYear), modifier = Modifier.padding(1.dp), textAlign = TextAlign.Center)
                }
            }
            Row (modifier = Modifier.padding(5.dp)) {
                Button(onClick = { index = (index - 1 + artworks.size) % artworks.size }) { Text(text = stringResource(R.string.previous), Modifier.padding(5.dp)) }
                Spacer(Modifier.width(10.dp))
                Button(onClick = { index = (index + 1) % artworks.size }) { Text(text = stringResource(R.string.next), Modifier.padding(5.dp)) }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace( modifier = Modifier,
            artworks = listOf<Artwork>(
                Artwork(R.drawable.meninas, R.string.las_meninas_1656, R.string.diego_velazquez),
                Artwork(R.drawable.beso, R.string.el_beso_1908_1909, R.string.gustav_klimt),
                Artwork(R.drawable.el_aquelarre_goya, R.string.el_aquelarre_1789_1798, R.string.francisco_de_goya),
                Artwork(R.drawable.perla, R.string.la_joven_de_la_perla_1665, R.string.johannes_vermeer),
                Artwork(R.drawable.naturaleza_muerta_remedios_varo, R.string.naturaleza_muerta_resucitando_1963, R.string.remedios_varos)
            )
        )
    }
}


data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val title: Int,
    @StringRes val artistYear: Int
)