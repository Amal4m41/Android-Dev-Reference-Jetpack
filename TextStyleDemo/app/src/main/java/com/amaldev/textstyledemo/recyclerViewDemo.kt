package com.amaldev.textstyledemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amaldev.textstyledemo.UserCard



data class User(
    val id:Int
)

val users = listOf(
    User(1),
    User(2),
    User(3),
    User(4),
    User(5),
    User(6),
    User(7)
)



@Composable
fun UserList(){
/*
Mimic recycler view, but it's not... the benefit of recycler view is that the we'll only compose the layouts which are currently
visible in the viewport. But in this approach when we run the app all the usercard layouts are composed. Therefore instead of
column we have to use lazycolumn
*/
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        for (i in 0..10){
//            UserCard()
//        }
//    }

//Now we'll only compose those items which are visible in the viewport.(Recycler View)
    LazyColumn{
        items(users){userItem ->                            //items it just like the recycler view adapter, we just pass the list
            UserCard(userItem)
        }
    }
}