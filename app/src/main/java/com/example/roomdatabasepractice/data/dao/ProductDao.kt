package com.example.roomdatabasepractice.data.dao

import androidx.room.*
import com.example.roomdatabasepractice.data.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product : Product)

    @Update
    suspend fun updateProduct(product : Product)

    @Query("SELECT * FROM product")
    fun getAllProducts() : Flow<List<Product>>

    @Query("DELETE from product")
    suspend fun deleteAllProducts()

    @Delete
    suspend fun deleteProduct(product : Product)
}