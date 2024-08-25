package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToDoAppTheme {
                val nav = rememberNavController()
                NavHost(navController = nav, startDestination ="login" , builder ={

                    composable("login"){
                        LoginScreen(nav)
                    }
                    composable("home"+"/{email}"){
                        var email= it.arguments?.getString("email")
                        HomeScreen(nav,email?:"ali")
                    }
                    composable("bottom"+"/{email}"){
                        var email= it.arguments?.getString("email")
                        bottom(nav = nav, email =email?:"ali" )
                    }
                } )

            }


        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ToDoAppTheme {
//        LoginScreen()
//
//
//    }
//    }
