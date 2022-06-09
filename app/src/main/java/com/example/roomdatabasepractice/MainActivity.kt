package com.example.roomdatabasepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabasepractice.presentation.ui.navigation.navgraph.MainNavGraph
import com.example.roomdatabasepractice.presentation.ui.theme.RoomDatabasePracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDatabasePracticeTheme {
                val navController = rememberNavController()
                MainNavGraph(navController = navController)
            }
        }
    }
}


