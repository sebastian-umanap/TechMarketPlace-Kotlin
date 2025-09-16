// MainActivity.kt
package com.team26.techmarketplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.team26.techmarketplace.core.designsystem.TMTheme
import com.team26.techmarketplace.feature.auth.LoginScreen
import com.team26.techmarketplace.feature.auth.RegisterScreen
import com.team26.techmarketplace.feature.onboarding.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(onContinue = { nav.navigate("login") })
                        }
                        composable("login") {
                            LoginScreen(
                                onRegister = { nav.navigate("register") }
                            )
                        }
                        composable("register") {
                            // Volver al login (mejor usamos popBackStack para no duplicar)
                            RegisterScreen(onLoginNow = { nav.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}
