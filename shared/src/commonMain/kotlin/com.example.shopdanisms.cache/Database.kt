package com.example.shopdanisms.cache

import com.example.shopdanisms.entity.Product
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

internal class Database(
    databaseDriverFactory: DatabaseDriverFactory
) : CommonData<Product> {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    override suspend fun insert(model: Product) {
        dbQuery.insert(
            name = model.name,
            description = model.description,
            company = model.company,
            purchasePrice = model.purchasePrice.toDouble(),
            salePrice = model.salePrice.toDouble(),
            isPaid = model.isPaid,
            isSold = model.isSold
        )
    }

    override suspend fun update(model: Product) {
        dbQuery.update(
            id = model.id,
            name = model.name,
            description = model.description,
            company = model.company,
            purchasePrice = model.purchasePrice.toDouble(),
            salePrice = model.salePrice.toDouble(),
            isPaid = model.isPaid,
            isSold = model.isSold
        )
    }

    override suspend fun delete(id: Long) {
        dbQuery.deleteById(id)
    }

    override fun getById(id: Long): Flow<Product> {
        return dbQuery.getById(id = id, mapper = ::mapProduct)
            .asFlow()
            .map {
                it.executeAsOne()
            }
            .catch { it.printStackTrace() }
    }

    override fun getAll(): Flow<List<Product>> {
        return dbQuery.getAll(::mapProduct).asFlow().mapToList(Dispatchers.IO)
    }

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAll()
        }
    }

    private fun mapProduct(
        id: Long,
        name: String,
        description: String,
        company: String,
        purchasePrice: Double,
        salePrice: Double,
        isPaid: Boolean,
        isSold: Boolean
    ): Product {
        return Product(
            id = id,
            name = name,
            description = description,
            company = company,
            purchasePrice = purchasePrice.toFloat(),
            salePrice = salePrice.toFloat(),
            isPaid = isPaid,
            isSold = isSold
        )
    }
}