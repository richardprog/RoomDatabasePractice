package com.example.roomdatabasepractice.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabasepractice.data.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertProduct(product : Product)

    suspend fun updateProduct(product : Product)

    fun getAllProducts() : Flow<List<Product>>

    suspend fun deleteAllProducts()

    suspend fun deleteProduct(product : Product)
}