package com.example.roomdatabasepractice.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner(
    @PrimaryKey val id : Int? = null,
    val firstName : String,
    val lastName : String,
    val age : Int
)
