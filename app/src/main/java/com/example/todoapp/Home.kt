package com.example.todoapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(nav:NavController,email:String) {
       var x by remember {
           mutableStateOf(0)
       }
     val context = LocalContext.current
     val myDialog = AlertDialog.Builder(context)
        Column(

            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "welcome back $email", style = TextStyle(
                fontSize = 28.sp,
                color = Color.Magenta
            ))
            Text(text = "$email  have $x tasks ", style = TextStyle(
                fontSize = 28.sp,
                color = Color.White
            ))

            Button(onClick = {
                nav.navigate("login")
            }) {
                Text(text = "go back",style = TextStyle(
                    fontSize = 28.sp,
                    color = Color.Magenta
                ))
            }
            Spacer(Modifier.height(350.dp))
            Row {
                Spacer(modifier = Modifier.width(290.dp))
                FloatingActionButton(

                    onClick = {
                              myDialog.setTitle("add Task")
                              myDialog.setMessage("Task added")
                              myDialog.setPositiveButton("done"){dialog, which->
                                        x=x+1
                                }
                              myDialog.setNegativeButton("cansale"){dialog,which ->

                              }
                              myDialog.setCancelable(true)
                        val dialog = myDialog.create()
                        dialog.show()
                              },
                    contentColor = Color.White ,
                    containerColor = Color.Blue,
                ) {
                    Icon(Icons.Filled.Add, contentDescription ="" )
                }
            }
            

        }
    }

data class navgate
    (
    val title:String,
     val selectedIcon:ImageVector,
     val unselectedIcon:ImageVector
            )


