package com.amaldev.composestatedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amaldev.composestatedemo.ui.theme.ComposeStateDemoTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val color = remember {
                mutableStateOf(Color.Yellow)
            }

//            ColorBox(modifier = Modifier.fillMaxSize())
            Column{
                ChangeExternalBoxColor(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()){
                    color.value = it
                }

                //Doing the same but using callback using interface
//                ChangeExternalBoxColor(modifier = Modifier
//                    .weight(1f)
//                    .fillMaxSize(),object: UpdateColor{
//                    override fun updateColor(colorValue: Color) {
//                        color.value = colorValue
//                    }
//                })

                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color.value))
            }
            
        }
    }
}

@Composable
//fun ChangeExternalBoxColor(modifier: Modifier = Modifier, actionUpdateColor: UpdateColor){
fun ChangeExternalBoxColor(modifier: Modifier = Modifier, actionUpdateColor: (Color) -> Unit){

    //Declaring the state
//    val color = remember{
//        //Remember the value produced by calculation. calculation will only be evaluated during the
//        // composition. Recomposition will always return the value produced by composition.
//        mutableStateOf(Color.Yellow)
//    }

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
             actionUpdateColor(  //calling the anonymous function callback with the Color value as parameter.
                 Color(
                    Random.nextFloat(),  //R (0-1 value)
                    Random.nextFloat(),  //G
                    Random.nextFloat(),  //B
                    1f)
             )

//             actionUpdateColor.updateColor(  //calling the anonymous function callback with the Color value as parameter.
//                     Color(
//                    Random.nextFloat(),  //R (0-1 value)
//                    Random.nextFloat(),  //G
//                    Random.nextFloat(),  //B
//                    1f)
//             )
        }
    )
}

interface UpdateColor{
    fun updateColor(colorValue:Color):Unit
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStateDemoTheme {

    }
}