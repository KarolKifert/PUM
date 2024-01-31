package com.shoppinglist

import android.content.Context
import androidx.room.Room
import com.shoppinglist.data.AppDatabase
import com.shoppinglist.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProductRepository(@ApplicationContext context: Context): ProductRepository {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "products-db"
        ).build()
        return db.productRepository()
    }
}