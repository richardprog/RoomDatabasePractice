package com.example.roomdatabasepractice.ui.product_menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasepractice.ui.navigation.Screen
import com.example.roomdatabasepractice.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductMenuViewModel @Inject constructor() : ViewModel() {
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event : ProductMenuEvent) {
        when (event) {
            is ProductMenuEvent.OnClickProductListButton -> {
                sendUiEvent(UiEvent.Navigate(Screen.ProductListScreen.route))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}