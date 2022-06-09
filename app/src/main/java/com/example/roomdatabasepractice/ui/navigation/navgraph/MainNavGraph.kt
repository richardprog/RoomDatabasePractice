package com.example.roomdatabasepractice.ui.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdatabasepractice.ui.home_menu.HomeMenuScreen
import com.example.roomdatabasepractice.ui.navigation.Screen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeMainScreen.route
    ) {
        composable(route = Screen.HomeMainScreen.route) {
            HomeMenuScreen(
                onNavigate = {
                    navController.navigate(it.route)
                }
            )
        }
        productMenuNavGraph(navController = navController)
        ownerMenuNavGraph(navController = navController)
    }
}