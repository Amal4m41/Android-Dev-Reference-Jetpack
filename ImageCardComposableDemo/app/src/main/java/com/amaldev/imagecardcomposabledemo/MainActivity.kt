package com.amaldev.imagecardcomposabledemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amaldev.imagecardcomposabledemo.ui.theme.ImageCardComposableDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.messi2) //get the image from resources
            val description = "Messi photo"  //for the screen readers if enabled.
            val title = "Messi the GOAT"

            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(10.dp)) {

                ImageCard(painter = painter, contextDescription = description , title = title)
            }

        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,   //to let us use an image from the image resources
    contextDescription: String,
    title: String,
    modifier: Modifier = Modifier
){

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        //Box is just a normal container like Column,Row and we can put composables inside it, and each item we put inside
        //it is going to be stacked on top of each other and we can also align this items.
        Box(modifier = Modifier.height(200.dp)) {
            //The first component will be at the bottom of the stack
            Image(painter = painter,
                contentDescription = contextDescription,
                contentScale = ContentScale.Crop)

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    //brush to define the gradient, vertical gradient cuz we want a gradient from bottom to the top or vice-versa.
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  //transition from color
                            Color.Black   //transition to color
                        ),
                        startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()  //fill the size of the parent container which is also a box.
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart) {

                Text(title,style = TextStyle(color= Color.White,fontSize = 16.sp))
            }

        }
    }
}