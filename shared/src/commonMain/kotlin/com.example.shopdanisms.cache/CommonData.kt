package com.example.shopdanisms.cache

import kotlinx.coroutines.flow.Flow

internal interface CommonData<T> {
    suspend fun insert(model: T)
    suspend fun update(model: T)
    suspend fun delete(id: Long)
    fun getById(id: Long): Flow<T>
    fun getAll(): Flow<List<T>>
}