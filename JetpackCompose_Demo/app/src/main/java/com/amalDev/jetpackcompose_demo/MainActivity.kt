package com.amalDev.jetpackcompose_demo


import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amalDev.jetpackcompose_demo.ui.theme.JetpackCompose_DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            JetpackCompose_DemoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//            Greeting(name = "Amal")
            Column(modifier = Modifier
                .width(200.dp)
                .fillMaxHeight(0.7f)
//                .fillMaxWidth()
                .background(Color.Green)
                .padding(10.dp)
                .border(5.dp, Color.Blue)
                .padding(5.dp)
                .border(10.dp, Color.Yellow)
                .padding(10.dp)
                .border(5.dp, Color.Red)
                .padding(5.dp)
                ){
                Text(text = "Hello",modifier = Modifier
                    .border(10.dp, Color.Magenta)
                    .padding(15.dp)
                    .border(15.dp, Color.Black)
                    .padding(15.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "World")
                Text(text = "Again")
            }


        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(
//    name = "My Preview",
//    showSystemUi = true
//)
//@Composable
//fun DefaultPreview() {
//    Row(modifier = Modifier
//        .width(200.dp)
//        .fillMaxHeight(0.7f)
//        .background(Color.Green),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceAround){
//        Text(text = "Hello")
//        Text(text = "World")
//        Text(text = "Again")
//    }
//}