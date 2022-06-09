package com.example.roomdatabasepractice.presentation.home_menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasepractice.presentation.Screen
import com.example.roomdatabasepractice.presentation.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel @Inject constructor() : ViewModel() {
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event : HomeMenuEvent) {
        when (event) {
            is HomeMenuEvent.OnClickProductMenuButton -> {
                sendUiEvent(UiEvent.Navigate(Screen.ProductMainScreen.route))
            }
            is HomeMenuEvent.OnClickOwnerMenuButton -> {
                sendUiEvent(UiEvent.Navigate(Screen.OwnerMainScreen.route))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}