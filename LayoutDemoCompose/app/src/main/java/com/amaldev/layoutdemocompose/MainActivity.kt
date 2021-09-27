package com.amaldev.layoutdemocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.amaldev.layoutdemocompose.ui.theme.LayoutDemoComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            TextFieldButtonSnackbarDemo()

            //We define the id for the elements we want to constraint, and the constraints we want on them.
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")

                val guideline = createGuidelineFromTop(0.5f)  //take 50 percent of the screen from top

                //defining the constraint
                constrain(greenBox){
//                    this.top.linkTo(parent.top)
                    this.top.linkTo(guideline)
                    start.linkTo(parent.start)

                    width= Dimension.value(100.dp)
                    height= Dimension.value(100.dp)
                }

                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width= Dimension.value(100.dp)
//                    width= Dimension.fillToConstraints  //similar to 0dp width
                    height= Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox,redBox,chainStyle = ChainStyle.Packed)

            }

            ConstraintLayout(constraints,modifier = Modifier.fillMaxSize()) {

                Box(modifier = Modifier
                    .background(Color.Green)
                    .layoutId("greenBox"))  //assigning the id

                Box(modifier = Modifier
                    .background(Color.Red)
                    .layoutId("redBox"))

            }
        }
    }
}


@Composable
fun TextFieldButtonSnackbarDemo(){

    val scaffoldState = rememberScaffoldState()
//            val textFieldState = remember{   //can be accessed by textFieldState.value
//                mutableStateOf("")
//            }

    var textFieldState by remember{  //we can directly access by using textFieldState
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 50.dp)
        ) {

            TextField(
                value = textFieldState,
                onValueChange = {
                    textFieldState = it //will assign the state and recompose all the composables that has to do with this state.
                } ,
                label = {
                    Text(text = "Enter Name")  //hint text
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello ${textFieldState}")
                }
            },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Click me!")
            }

        }
    }

}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutDemoComposeTheme {
        Greeting("Android")
    }
}