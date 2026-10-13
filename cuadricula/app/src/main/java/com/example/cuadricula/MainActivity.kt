package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.models.Topic
import com.example.cuadricula.ui.theme.CuadriculaTheme
import com.example.cuadricula.data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuadriculaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CuadriculaApp(modifier = Modifier.padding(innerPadding), DataSource.topics)
                }
            }
        }
    }
}


@Composable
fun CuadriculaApp(modifier: Modifier = Modifier, topics : List<Topic>) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 200.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),

    ) {
        items(topics) { topic -> Cuadricula(modifier,topic) }
    }

}


@Composable
fun Cuadricula(modifier : Modifier = Modifier, topic: Topic) {

    Card(Modifier.height(68.dp).width(200.dp)) {
        Row(Modifier.fillMaxSize().background(color = Color.LightGray)) {
            Image(
                painter = painterResource(topic.imageRes),
                contentDescription = null,
                Modifier.fillMaxHeight().width(68.dp),
                contentScale = ContentScale.FillHeight
            )
            Spacer(Modifier.width(16.dp))
            Column (Modifier.padding(top = 16.dp, end = 16.dp)) {
                Text(
                    text = stringResource(topic.nameRes),
                    modifier = modifier
                )
                Spacer(Modifier.height(8.dp))
                Row {
                    Image(
                        painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = topic.number.toString(),
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CuadriculaPreview() {
    CuadriculaTheme {
        Cuadricula(topic = Topic(R.string.architecture, 58, R.drawable.architecture))
    }
}


@Preview(showBackground = true)
@Composable
fun CuadriculaAppPreview() {
    CuadriculaTheme {
        CuadriculaApp(modifier = Modifier, DataSource.topics)
    }
}