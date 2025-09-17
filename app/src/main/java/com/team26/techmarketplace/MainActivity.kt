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
import androidx.navigation.NavGraph.Companion.findStartDestination

import com.team26.techmarketplace.core.designsystem.TMTheme
import com.team26.techmarketplace.feature.auth.LoginScreen
import com.team26.techmarketplace.feature.auth.RegisterScreen
import com.team26.techmarketplace.feature.home.HomeScreen
import com.team26.techmarketplace.feature.onboarding.WelcomeScreen
import com.team26.techmarketplace.core.ui.BottomItem
import com.team26.techmarketplace.feature.home.HomeScreen
import com.team26.techmarketplace.feature.order.OrderScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "welcome") {
                        composable("welcome") { WelcomeScreen(onContinue = { nav.navigate("login") }) }
                        composable("login") {
                            LoginScreen(
                                onRegister = { nav.navigate("register") },
                                onLogin = {
                                    nav.navigate("home") {
                                        popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                        composable("register") { RegisterScreen(onLoginNow = { nav.popBackStack() }) }

                        composable(BottomItem.Home.route) {
                            HomeScreen(onNavigateBottom = { dest ->
                                nav.navigate(dest.route) {
                                    popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })
                        }
                        composable(BottomItem.Order.route) {
                            OrderScreen(onNavigateBottom = { dest ->
                                nav.navigate(dest.route) {
                                    popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })
                        }
                        // (Opcionales)
                        composable(BottomItem.Cart.route) { /* TODO */ }
                        composable(BottomItem.Profile.route) { /* TODO */ }
                    }
                }
            }
        }
    }
}
