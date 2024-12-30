package com.example.shoppingevents.hiltModules

import com.example.shoppingevents.data.repos.ShoppingEventRepository
import com.example.shoppingevents.data.repos.ShoppingEventRepositoryImpl
import com.example.shoppingevents.data.repos.ShoppingItemRepository
import com.example.shoppingevents.data.repos.ShoppingItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/* To tell hilt how to implement the repository */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindShoppingEventRepository(
        impl: ShoppingEventRepositoryImpl
    ): ShoppingEventRepository

    @Binds
    abstract fun bindShoppingItemRepository(
        impl: ShoppingItemRepositoryImpl
    ): ShoppingItemRepository

}