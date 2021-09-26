package com.amaldev.composestatedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random


/*
Whenever we click on the box, we're reassigning the state of the color 'state'. Eveytime we change the state
of the color variable below it'll tell compose to rewrite the compose(recompose) i.e. it'll redraw that UI
it'll call the ColorBox function again to do this, but the problem is when the compose is recomposed, this function
will be called again and we'll be resetting the state too everytime we do it which won't work cuz we're
setting it to yellow color everytime, therefore to fix this we use 'remember' which will remember the value of
the state from the last composition so that it won't be reset in every recomposition.
 */
@Composable
fun ColorBox(modifier: Modifier = Modifier){

    //Declaring the state
    val color = remember{           //since this is a state bothering a specific compose it's called internal state.
        //Remember the value produced by calculation. calculation will only be evaluated during the
        // composition. Recomposition will always return the value produced by composition.
        mutableStateOf(Color.Yellow)
    }

    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),  //R (0-1 value)
                Random.nextFloat(),  //G
                Random.nextFloat(),  //B
                1f
            )
        }
    )
}