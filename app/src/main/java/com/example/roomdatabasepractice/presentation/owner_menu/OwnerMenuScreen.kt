package com.example.roomdatabasepractice.presentation.ui.owner_menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabasepractice.presentation.UiEvent

@Composable
fun OwnerMenuScreen(
    onNavigate : (UiEvent.Navigate) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.width(200.dp)
        ) {
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Owner List")
            }
        }
    }
}