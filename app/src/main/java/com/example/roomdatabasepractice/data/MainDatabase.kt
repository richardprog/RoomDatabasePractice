package com.example.roomdatabasepractice.data

import androidx.room.*
import com.example.roomdatabasepractice.data.dao.OwnerDao
import com.example.roomdatabasepractice.data.dao.ProductDao
import com.example.roomdatabasepractice.data.entity.Owner
import com.example.roomdatabasepractice.data.entity.Product

@Database(entities = [Product::class, Owner::class], version = 2, exportSchema = false)
abstract class MainDatabase: RoomDatabase() {
    abstract fun productDao() : ProductDao
    abstract fun ownerDao() : OwnerDao
}

