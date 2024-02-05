package com.example.composedemo


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.GreenSpotify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Surface(color = GreenSpotify) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .navigationBarsPadding(),
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
            textColor = White,
            cursorColor = White,
            backgroundColor = Transparent,
            focusedIndicatorColor = White,
            unfocusedIndicatorColor = White,
        ),
        textStyle = TextStyle(fontSize = 20.sp),
        trailingIcon = {
            val context = LocalContext.current
            IconButton(
                onClick = { Toast.makeText(context, text, Toast.LENGTH_SHORT).show() },
                content = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = White
                    )
                }
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