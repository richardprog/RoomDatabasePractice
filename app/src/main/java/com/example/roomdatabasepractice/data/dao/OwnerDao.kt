package com.example.roomdatabasepractice.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabasepractice.data.entity.Owner
import com.example.roomdatabasepractice.data.entity.Product

@Dao
interface OwnerDao {
    @Insert
    suspend fun insertOwner(owner : Owner)

    @Query("SELECT * FROM owner")
    suspend fun getAllOwners() : List<Owner>
}