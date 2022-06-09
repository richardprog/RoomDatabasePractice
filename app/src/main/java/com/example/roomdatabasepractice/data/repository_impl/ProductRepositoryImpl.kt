package com.example.roomdatabasepractice.data.repository_impl

import com.example.roomdatabasepractice.data.dao.ProductDao
import com.example.roomdatabasepractice.data.entity.Product
import com.example.roomdatabasepractice.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val dao : ProductDao
) : ProductRepository {
    override suspend fun insertProduct(product: Product) {
        dao.insertProduct(product)
    }

    override suspend fun updateProduct(product: Product) {
        dao.updateProduct(product)
    }

    override fun getAllProducts(): Flow<List<Product>> {
        return dao.getAllProducts()
    }

    override suspend fun deleteAllProducts() {
        dao.deleteAllProducts()
    }

    override suspend fun deleteProduct(product: Product) {
        dao.deleteProduct(product)
    }
}