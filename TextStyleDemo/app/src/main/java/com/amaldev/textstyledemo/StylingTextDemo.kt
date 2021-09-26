package com.amaldev.textstyledemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun DemoTextStyle(){




    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xff000000))){
        
        Text(
            //To give individual styles to text.
            text= buildAnnotatedString {
               //withStyle let's us to give individual styles
                withStyle(
                   style = SpanStyle(
                       color = Color.Green,
                       fontSize = 50.sp
                   )
               ){
                    append("J")
                }
                append("etpack")
                withStyle(
                   style = SpanStyle(
                       color = Color.Green,
                       fontSize = 50.sp
                   )
               ){
                    append("C")
                }
                append("ompose")
            },
//            text = "Jetpack Compose",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamilyCustom,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.fillMaxWidth()
        )

    }
}