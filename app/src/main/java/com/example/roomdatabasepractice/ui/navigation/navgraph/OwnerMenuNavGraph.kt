package com.example.roomdatabasepractice.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.roomdatabasepractice.ui.navigation.Screen
import com.example.roomdatabasepractice.ui.owner_menu.OwnerMenuScreen

fun NavGraphBuilder.ownerMenuNavGraph(navController: NavController) {
    composable(route = Screen.OwnerMainScreen.route) {
        OwnerMenuScreen(
            onNavigate = {
                navController.navigate(it.route)
            }
        )
    }
}