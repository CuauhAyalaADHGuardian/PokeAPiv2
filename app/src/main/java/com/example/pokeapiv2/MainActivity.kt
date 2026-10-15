package com.example.pokeapiv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokeapiv2.ui.theme.PokeAPiv2Theme

class MainActivity : ComponentActivity() {
    private val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAPiv2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }


    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    rememberAsyncImagePainter: (String) -> Painter
) {
    var mText by remember { mutableStateOf(name) }
    Column(modifier = Modifier.padding(6.dp).fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextField(
                value = mText,
                onValueChange = { mText = it },
            )
            Button(onClick = {}) {
                Text(text = "Submit")
            }
        }

        Column(Modifier.fillMaxSize()) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }


        LazyColumn() {
            Row() {
                Text(text = "Hello $name!")
                Image(painter = rememberAsyncImagePainter("https://example.com/image.png"),
                    contentDescription = "Remote Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp))

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeAPiv2Theme {
        Greeting("Pikachu",)
    }
}