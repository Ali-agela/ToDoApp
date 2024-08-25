package com.example.todoapp


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottom(nav:NavController,email:String){
    val items= listOf<navgate>(
        navgate(
            "home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ) ,
        navgate(
            "profile",
            Icons.Filled.AccountCircle,
            Icons.Outlined.AccountCircle
        ),
        navgate(
            "settings",
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        ),
    )
    val pages = listOf<Unit>(
        HomeScreen(nav,email ),
        profile(),
        settings(),
    )

    var  selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed{   index,item ->
                    NavigationBarItem (
                        selected = selectedIndex==index,
                        onClick ={
                            selectedIndex=index
                        },
                        label = {
                            Text(text = item.title)
                        },
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                imageVector = if (index==selectedIndex){
                                    item.selectedIcon
                                }else{
                                    item.unselectedIcon
                                },
                                contentDescription = item.title
                            )
                        }
                    )
                }
            }
        }

    ) { innerpadding ->
        if(selectedIndex==1){
            profile()
        }
        if(selectedIndex==0){
            HomeScreen(nav = nav, email =email )
        }
        if(selectedIndex==2){
            settings()
        }
        print(innerpadding)
    }
}