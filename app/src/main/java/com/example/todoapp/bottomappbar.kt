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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
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
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottom(nav:NavController,email:String){
    val draweritems =listOf<draweritem>(
        draweritem(
            title = "Home",
            selectedIconn =Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            badgeCount = 15,
        ),
        draweritem(
            title = "Settings",
            selectedIconn =Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
        draweritem(
            title = "Urgent",
            selectedIconn =Icons.Filled.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            badgeCount = 15,
        )
    )
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


    var  selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val drawerState = rememberDrawerState(initialValue=DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedIndexDrawer by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(16.dp))
                draweritems.forEachIndexed(){index,item ->
                    NavigationDrawerItem(label = { Text(text = item.title)},
                        selected =  index==selectedIndexDrawer ,
                        onClick = {
                            selectedIndexDrawer=index
                            scope.launch(){
                                drawerState.close()
                            }
                        },
                        icon = {
                            if (index==selectedIndexDrawer){
                            Icon(item.selectedIconn, contentDescription =item.title )}
                            else{ Icon(item.unselectedIcon, contentDescription =item.title )}
                        },
                        badge = {
                            if(item.badgeCount!=null){
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    )
                }

            }

    }, drawerState = drawerState
        ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(text = "ToDoApp")},
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Outlined.Menu, contentDescription ="menu")
                        }
                    }
                )
            },
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

}

data class draweritem(
    val title:String,
    val selectedIconn:ImageVector,
    val unselectedIcon:ImageVector,
    val badgeCount:Int?=null
)