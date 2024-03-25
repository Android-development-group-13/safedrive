package com.example.safedrive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safedrive.screens.HomeScreen
import com.example.safedrive.screens.LoginScreen
import com.example.safedrive.screens.RecordDriveScreen
import com.example.safedrive.screens.SettingsScreen
import com.example.safedrive.screens.SignUpScreen
import com.example.safedrive.screens.WelcomeScreen
import com.example.safedrive.ui.theme.SafedriveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafedriveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  NavigationApp()
                }
            }
        }
    }
}


@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable(route = "welcome") {
            WelcomeScreen(navController)
        }
        composable(
            route = "login"
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = "signup"
        ) {
            SignUpScreen(navController = navController)
        }
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "record_drive") {
            RecordDriveScreen(navController = navController)
        }
        composable(route = "settings") {
            SettingsScreen(navController = navController)
        }
        /*composable(

            route = "signup", arguments = listOf(navArgument(name = "country") {
                type = NavType.StringType
            })
        ) { it ->
            it.arguments?.getString("country")?.let { it1 -> SinglePage(navController, it1) }

        }*/

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SafedriveTheme {
        Greeting("Android")
    }
}