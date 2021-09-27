package com.amaldev.layoutdemocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amaldev.layoutdemocompose.ui.theme.LayoutDemoComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

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