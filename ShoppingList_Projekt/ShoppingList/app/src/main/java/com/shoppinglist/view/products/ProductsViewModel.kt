package com.shoppinglist.view.products

import androidx.lifecycle.ViewModel
import com.shoppinglist.model.Product
import com.shoppinglist.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    fun getAllProducts(): Flow<List<Product>> {
        return productRepository.getAll()
    }

}