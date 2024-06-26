package com.vipulasri.jetinstagram.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
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

        Row (

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier
                    .clickable { /* Handle left icon click */ }
                    .size(35.dp),
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                )


            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(15.dp),
                fontFamily = FontFamily.SansSerif, //font type
                style = TextStyle(
                    fontSize = 15.sp, // Change the font size as per your requirement
                    color = Color.Black, // Change the text color as per your requirement
                    fontWeight = FontWeight.Bold
                ),

                text = "Favorites" //text to be displayed,
            )

            Icon(
                modifier = Modifier
                    .clickable { /* Handle right icon click */ }
                    .size(35.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }



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
            Item("Account Name 1", "accountTag1", R.drawable.ic_dm),
            Item("Account Name 2", "accountTag2", R.drawable.ic_filled_favorite),
            Item("Account Name 3", "accountTag3", R.drawable.ic_filled_bookmark),
            Item("Account Name 4", "accountTag4", R.drawable.ic_instagram),
            Item("Account Name 5", "accountTag5", R.drawable.ic_outlined_camera),
            Item("Account Name 6", "accountTag6", R.drawable.ic_filled_home)
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
                .padding(16.dp)
                .height(50.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp),
            placeholder = { Text(
                text = placeholderText
            ) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.LightGray
            ),
            shape = RoundedCornerShape(8.dp)
        )


}

data class Item(val accountName: String, val accountTagName: String, var image: Int)

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
                Row(
                    modifier = Modifier.height(60.dp)
                ){

                    Image(
                        painter = painterResource(id = item.image), // Replace R.drawable.your_image with your actual image resource
                        contentDescription = null, // You can provide a content description if needed
                        modifier = Modifier.size(48.dp) // Adjust size as needed
                    )


                    Column(
                        modifier = Modifier
                            .width(230.dp)
                            .padding(start = 20.dp)
                    ) {
                        // Content inside each card
                        Text(
                            text = item.accountName,
                            modifier = Modifier,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 20.sp
                            )
                        )
                        Text(
                            color = Color.Gray,
                            text = item.accountTagName,
                            modifier = Modifier,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 15.sp
                            )
                        )


                    }
                    //Text(text = item.description)
                    Spacer(modifier = Modifier.width(16.dp)) // Add space between Image and Button
                    Button(
                        onClick = { /*TODO*/ },
                    ) {
                        Text(text = "Add")
                    } // Add Button here

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