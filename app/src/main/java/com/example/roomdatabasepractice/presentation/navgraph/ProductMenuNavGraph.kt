package com.example.roomdatabasepractice.presentation.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.roomdatabasepractice.presentation.Screen
import com.example.roomdatabasepractice.presentation.product_list.ProductListScreen
import com.example.roomdatabasepractice.presentation.product_menu.ProductMenuScreen

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