package com.example.roomdatabasepractice.ui.home_menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomdatabasepractice.util.UiEvent

@Composable
fun HomeMenuScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: HomeMenuViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.width(200.dp)
        ) {
            Button(
                onClick = {
                    viewModel.onEvent(HomeMenuEvent.OnClickProductMenuButton)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Product")
            }
            Button(
                onClick = {
                    viewModel.onEvent(HomeMenuEvent.OnClickOwnerMenuButton)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Owner")
            }
        }
    }
}