package com.example.roomdatabasepractice.presentation.ui.navigation.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.roomdatabasepractice.presentation.Screen
import com.example.roomdatabasepractice.presentation.ui.owner_menu.OwnerMenuScreen

fun NavGraphBuilder.ownerMenuNavGraph(navController: NavController) {
    composable(route = Screen.OwnerMainScreen.route) {
        OwnerMenuScreen(
            onNavigate = {
                navController.navigate(it.route)
            }
        )
    }
}