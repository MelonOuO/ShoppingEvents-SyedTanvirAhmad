package com.example.shoppingevents.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppingevents.data.daos.ShoppingEventDao
import com.example.shoppingevents.data.daos.ShoppingItemDao
import com.example.shoppingevents.data.entities.ShoppingEvent
import com.example.shoppingevents.data.entities.ShoppingItem

@Database(entities = [ShoppingEvent::class, ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun shoppingEventDao(): ShoppingEventDao
    abstract fun shoppingItemDao(): ShoppingItemDao

    companion object{
        const val DATABASE_NAME = "shopping_database"

        @Volatile
        private var Instance: ShoppingDatabase? = null

        fun getDatabase(context: Context): ShoppingDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context = context,
                    klass = ShoppingDatabase::class.java,
                    name = DATABASE_NAME
                ).build().also {
                    Instance = it
                }
            }
        }
    }
}