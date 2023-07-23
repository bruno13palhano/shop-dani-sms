package com.example.shopdanisms

import com.example.shopdanisms.cache.CommonData
import com.example.shopdanisms.cache.Database
import com.example.shopdanisms.cache.DatabaseDriverFactory
import com.example.shopdanisms.entity.Product
import kotlinx.coroutines.flow.Flow

class SmsSDK(databaseDriverFactory: DatabaseDriverFactory): CommonData<Product> {
    private val database = Database(databaseDriverFactory)

    override suspend fun insert(model: Product) {
        database.insert(model)
    }

    override suspend fun update(model: Product) {
        database.update(model)
    }

    override suspend fun delete(id: Long) {
        database.delete(id)
    }

    override fun getById(id: Long): Flow<Product> {
        return database.getById(id)
    }

    override fun getAll(): Flow<List<Product>> {
        return database.getAll()
    }
}