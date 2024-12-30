package com.example.shoppingevents.data.repos

import com.example.shoppingevents.data.daos.ShoppingEventDao
import com.example.shoppingevents.data.entities.ShoppingEvent
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 interface ShoppingEventRepository{
    suspend fun insert(shoppingEvent: ShoppingEvent)
    suspend fun update(shoppingEvent: ShoppingEvent)
    suspend fun delete(shoppingEvent: ShoppingEvent)
    fun getEvents(): Flow<List<ShoppingEvent>>
}

class ShoppingEventRepositoryImpl @Inject constructor(
    private val shoppingEventDao: ShoppingEventDao
): ShoppingEventRepository{
    override suspend fun insert(shoppingEvent: ShoppingEvent) {
        shoppingEventDao.insert(shoppingEvent)
    }

    override suspend fun update(shoppingEvent: ShoppingEvent) {
        shoppingEventDao.update(shoppingEvent)
    }

    override suspend fun delete(shoppingEvent: ShoppingEvent) {
        shoppingEventDao.delete(shoppingEvent)
    }

    override fun getEvents(): Flow<List<ShoppingEvent>> {
        return shoppingEventDao.getEvents()
    }

}