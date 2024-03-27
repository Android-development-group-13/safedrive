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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safedrive.components.BottomNavigationBar
import com.example.safedrive.components.NavRoute
import com.example.safedrive.components.TopBar
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
                  MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navController = navController, title = "") },
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationApp(navController = navController)
    }
}

@Composable
fun NavigationApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Welcome.route) {
        composable(route = NavRoute.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = NavRoute.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = NavRoute.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = NavRoute.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavRoute.RecordDrive.route) {
            RecordDriveScreen(navController = navController)
        }
        composable(route = NavRoute.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}
