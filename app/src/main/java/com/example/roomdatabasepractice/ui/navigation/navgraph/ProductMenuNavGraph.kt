package com.example.roomdatabasepractice.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.roomdatabasepractice.ui.navigation.Screen
import com.example.roomdatabasepractice.ui.product_list.ProductListScreen
import com.example.roomdatabasepractice.ui.product_menu.ProductMenuScreen

fun NavGraphBuilder.productMenuNavGraph(navController: NavController) {
    composable(route = Screen.ProductMainScreen.route) {
        ProductMenuScreen(
            onNavigate = {
                navController.navigate(it.route)
            }
        )
    }
    composable(route = Screen.ProductListScreen.route) {
        ProductListScreen()
    }
}