package com.example.roomdatabasepractice.data.repository_impl

import com.example.roomdatabasepractice.data.dao.OwnerDao
import com.example.roomdatabasepractice.data.entity.Owner
import com.example.roomdatabasepractice.data.repository.OwnerRepository

class OwnerRepositoryImpl(
    private val dao : OwnerDao
) : OwnerRepository {
    override suspend fun insertOwner(owner: Owner) {
        dao.insertOwner(owner)
    }

    override suspend fun getAllOwners(): List<Owner> {
        return dao.getAllOwners()
    }
}