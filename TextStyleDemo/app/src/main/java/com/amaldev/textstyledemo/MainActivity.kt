package com.amaldev.textstyledemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amaldev.textstyledemo.ui.theme.TextStyleDemoTheme


//Creating custom font
//The names of the fonts should be in lowercase and with underscore if necessary.
val fontFamilyCustom = FontFamily(
    Font(R.font.gemunulibre_light, FontWeight.Light ),
    Font(R.font.gemunulibre_medium, FontWeight.Medium ),
    Font(R.font.gemunulibre_bold, FontWeight.Bold )
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            UserList()
            DemoTextStyle()
        }
    }
}

@Composable
fun TitleText(textValue: String){
    val context = LocalContext.current  //getting the  context inside a composable function.

    Text(
        text = textValue,
        fontSize = 40.sp,
        color = colorResource(id = R.color.purple_700),
        fontFamily = FontFamily.Cursive,
        modifier = Modifier.clickable {
            Toast.makeText(context, "Title clicked", Toast.LENGTH_SHORT).show()
        }
    )
}

@Composable
fun UserCard(userItem: User){
    val context = LocalContext.current

    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp) //margin
            .wrapContentHeight()
    ){
        Row(
            modifier = Modifier
                //            .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)  //padding of the whole element(Margin)
    //            .border(2.dp, Color.Red)
    //            .padding(15.dp)  //padding inside the border
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Dummy Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(modifier = Modifier.fillMaxWidth()){
    //            Text(text = "Dummy Title")
                TitleText(userItem.id.toString())
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    Toast.makeText(context, "Clicked button", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Button Text")
                }
            }
        }
    }
}



@Preview
@Composable
fun MyPreview(){
    Surface(modifier = Modifier.fillMaxSize()) {
//        TitleText()
//        UserCard()
//        UserList()
        DemoTextStyle()
    }
}