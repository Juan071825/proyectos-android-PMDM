package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.models.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AffirmationsApp(
                        affirmationsList = listOf(
                            Affirmation(R.drawable.image1, R.string.affirmation1),
                            Affirmation(R.drawable.image2, R.string.affirmation2),
                            Affirmation(R.drawable.image3, R.string.affirmation3),
                            Affirmation(R.drawable.image4, R.string.affirmation4),
                            Affirmation(R.drawable.image5, R.string.affirmation5),
                            Affirmation(R.drawable.image6, R.string.affirmation6),
                            Affirmation(R.drawable.image7, R.string.affirmation7),
                            Affirmation(R.drawable.image8, R.string.affirmation8),
                            Affirmation(R.drawable.image9, R.string.affirmation9),
                            Affirmation(R.drawable.image10, R.string.affirmation10)
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp(affirmationsList : List<Affirmation>, modifier: Modifier = Modifier) {

    val lista = remember { mutableStateListOf<Affirmation>().apply { addAll(affirmationsList) } }

    ScrollInfinito(
        affirmations = lista,
        onCargarMas = { lista.addAll(affirmationsList) },
        modifier = modifier
    )

}


@Composable
fun ScrollInfinito(
    affirmations: List<Affirmation>,
    onCargarMas: () -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    // true cuando el último elemento visible es uno de los últimos 3 de la lista
    val cercaDelFinal by remember {
        derivedStateOf {
            val ultimoVisible = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            ultimoVisible >= listState.layoutInfo.totalItemsCount - 3
        }
    }

    LaunchedEffect(cercaDelFinal, affirmations.size) {
        if (cercaDelFinal) onCargarMas()
    }

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize().padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(affirmations) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}


@Composable
fun AffirmationCard(affirmation: Affirmation){

    Card(Modifier.width(350.dp)) {
        Column() {
            Image(
                painter = painterResource(affirmation.imageRes),
                contentDescription = null,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(affirmation.textRes),
                modifier = Modifier.padding(16.dp), fontSize = 20.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AffirmationCardPreview() {
    AffirmationsTheme {
        AffirmationCard(
            affirmation = Affirmation(R.drawable.image1, R.string.affirmation1)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AffirmationsTheme {
        AffirmationsApp(
            affirmationsList = listOf(
                Affirmation(R.drawable.image1, R.string.affirmation1),
                Affirmation(R.drawable.image2, R.string.affirmation2),
                Affirmation(R.drawable.image3, R.string.affirmation3),
                Affirmation(R.drawable.image4, R.string.affirmation4),
                Affirmation(R.drawable.image5, R.string.affirmation5),
                Affirmation(R.drawable.image6, R.string.affirmation6),
                Affirmation(R.drawable.image7, R.string.affirmation7),
                Affirmation(R.drawable.image8, R.string.affirmation8),
                Affirmation(R.drawable.image9, R.string.affirmation9),
                Affirmation(R.drawable.image10, R.string.affirmation10)
            )
        )
    }
}