package com.example.roomdatabasepractice.presentation

sealed class Screen(val route : String) {
    object HomeMainScreen : Screen("home_main_screen")
    object ProductMainScreen : Screen("product_main_screen")
    object ProductListScreen : Screen("product_list_screen")
    object OwnerMainScreen : Screen("owner_main_screen")
}
