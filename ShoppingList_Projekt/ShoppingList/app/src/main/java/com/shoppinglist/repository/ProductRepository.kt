package com.shoppinglist.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shoppinglist.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductRepository {

    @Query("SELECT * FROM product")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM product WHERE uid IN (:productId)")
    suspend fun getById(productId: Int): Product

    @Insert
    suspend fun insertAll(vararg products: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)
}