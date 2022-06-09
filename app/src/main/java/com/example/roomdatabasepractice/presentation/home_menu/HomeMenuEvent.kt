package com.example.roomdatabasepractice.presentation.home_menu

sealed class HomeMenuEvent {
    object OnClickProductMenuButton : HomeMenuEvent()
    object OnClickOwnerMenuButton : HomeMenuEvent()
}
