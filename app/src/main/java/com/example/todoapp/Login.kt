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
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(nav: NavController) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column (
       modifier = Modifier
           .fillMaxSize()
           .background(Color.White) ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(painter = painterResource(id = R.drawable.login) ,contentDescription = "Login image",
        modifier = Modifier.size(200.dp) )
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Login to your account")




        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email,onValueChange ={
            email = it
        }, label = { Text("Email")})


        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password,onValueChange ={
            password = it
        }, label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            nav.navigate("bottom/$email")
        }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Forget Password", Modifier.clickable {  })
        Spacer(modifier = Modifier.height(32.dp))

    }

}


