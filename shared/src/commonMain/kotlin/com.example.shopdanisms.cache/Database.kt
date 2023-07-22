package com.example.shopdanisms.cache

import com.example.shopdanisms.entity.Product
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAll(): Flow<List<Product>> {
        return dbQuery.getAll(::mapProduct).asFlow().mapToList(Dispatchers.IO)
    }

    internal fun createProduct(product: Product) {
        dbQuery.transaction {
            dbQuery.insertProduct(
                name = product.name,
                price = product.price.toDouble()
            )
        }
    }

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllProducts()
        }
    }

    private fun mapProduct(
        id: Long,
        name: String,
        price: Double
    ): Product {
        return Product(id, name, price.toFloat())
    }
}