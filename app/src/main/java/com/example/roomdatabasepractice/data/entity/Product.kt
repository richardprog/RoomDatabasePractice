package com.example.roomdatabasepractice.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product (
    @PrimaryKey val id : Int? = null,
    val name : String,
    val description : String,
    val type : String
)