package com.example.shopdanisms

import com.example.shopdanisms.cache.Database
import com.example.shopdanisms.cache.DatabaseDriverFactory
import com.example.shopdanisms.entity.Product
import kotlinx.coroutines.flow.Flow

class SmsSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    fun getProducts(): Flow<List<Product>> {
        return database.getAll()
    }

    fun insertProduct(product: Product) {
        database.createProduct(product)
    }
}