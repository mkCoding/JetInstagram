package com.vipulasri.jetinstagram.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Favorites(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .padding(15.dp),
            fontFamily = FontFamily.SansSerif, //font type
            style = TextStyle(
                fontSize = 15.sp, // Change the font size as per your requirement
                color = Color.Black, // Change the text color as per your requirement
            ),
            text = "Favorites" //text to be displayed
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            fontFamily = FontFamily.SansSerif, //font type
            style = TextStyle(
                fontSize = 15.sp, // Change the font size as per your requirement
                color = Color.Black, // Change the text color as per your requirement
            ),
            text = "New post in your favorites will appear higher in feed. Only you can see who you add or remove. How it works"
        )

    //Add searchbox composable
        SearchBox(onSearchTextChanged = { /*TODO*/ })

        val items = listOf(
            Item("Title 1", "Description 1"),
            Item("Title 2", "Description 2"),
            Item("Title 3", "Description 3")
        )
        AccountsList(items = items)
    }

}

@Composable
fun SearchBox(
    onSearchTextChanged: (String) -> Unit
){
    var searchText by remember { mutableStateOf("") }

    val placeholderText = AnnotatedString.Builder().apply {
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append(" ")
            append("🔍") // Add your desired icon here
            append(" ")
        }
        append("Search...")
    }.toAnnotatedString()



        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearchTextChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text(placeholderText) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            shape = RoundedCornerShape(8.dp)
        )


}

data class Item(val title: String, val description: String)

@Composable
fun AccountsList(items:List<Item>) {
    LazyColumn {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                backgroundColor = Color.White // Customize card background color if needed
            ) {
                Row{
                    // Content inside each card
                    Text(
                        text = item.title
                    )
                    Text(text = item.description)
                }

            }
        }


    }
}


@Preview( showBackground = true)
@Composable
fun FavoritesPreview(){
    Favorites()
}