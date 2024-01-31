package com.shoppinglist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shoppinglist.model.Product
import com.shoppinglist.repository.ProductRepository

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productRepository(): ProductRepository
}