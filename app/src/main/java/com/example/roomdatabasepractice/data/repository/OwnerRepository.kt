package com.example.roomdatabasepractice.data.repository

import com.example.roomdatabasepractice.data.entity.Owner

interface OwnerRepository {
    suspend fun insertOwner(owner : Owner)

    suspend fun getAllOwners() : List<Owner>
}