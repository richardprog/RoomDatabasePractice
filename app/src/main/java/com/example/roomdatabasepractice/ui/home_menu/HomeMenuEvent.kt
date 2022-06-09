package com.example.roomdatabasepractice.ui.home_menu

sealed class HomeMenuEvent {
    object OnClickProductMenuButton : HomeMenuEvent()
    object OnClickOwnerMenuButton : HomeMenuEvent()
}
