package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.GreenSpotify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeDemoTheme {
                Surface(color = GreenSpotify) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                    ) {
//                        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                        SearchBar()
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Black,
            cursorColor = Black,
            backgroundColor = Transparent,
            focusedIndicatorColor = Black,
            unfocusedIndicatorColor = Black,
        ),
        textStyle = TextStyle(fontSize = 20.sp),
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                tint = Black
            )
        }
    )
}

@Composable
fun SearchResultsList() {

}

@Composable
fun SearchResultItem(itemViewState: SearchResultItemViewState) {
    Text(
        text = itemViewState.text,
        style = TextStyle(fontSize = 14.sp),
        color = Black,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}

data class SearchResultItemViewState(
    val text: String
)


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        SearchBar()
    }
}