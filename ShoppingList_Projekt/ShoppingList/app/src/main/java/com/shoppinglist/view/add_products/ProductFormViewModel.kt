package com.shoppinglist.view.add_products

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppinglist.model.Product
import com.shoppinglist.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductFormViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val productId = savedStateHandle.get<String>("id")

    private val _isEditing = MutableStateFlow(productId != null)
    val isEditing: StateFlow<Boolean> = _isEditing.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _amount = MutableStateFlow("1")
    val amount: StateFlow<String> = _amount.asStateFlow()

    init {
        if (productId != null && productId.isDigitsOnly()) {
            viewModelScope.launch {
                val product = productRepository.getById(productId.toInt())
                _name.value = product.name ?: ""
                _amount.value = product.amount.toString()
                _isEditing.value = true
            }
        } else {
            _isEditing.value = false
        }
    }

    fun onNameChanged(name: String) {
        _name.value = name
    }

    fun onAmountChanged(amount: String) {
        _amount.value = amount
    }

    fun save() {
        viewModelScope.launch {
            val amountInt = amount.value.toIntOrNull() ?: return@launch
            val nameIsNotInt = name.value.toIntOrNull() == null
            if (!nameIsNotInt) {
                return@launch
            }

            if (productId != null && productId.isDigitsOnly()) {
                productRepository.update(Product(productId.toInt(), name.value, amountInt))
            } else {
                productRepository.insertAll(Product(name.value, amountInt))
            }
        }
    }


    fun delete() {
        viewModelScope.launch {
            if (productId != null && productId.isDigitsOnly()) {
                productRepository.delete(Product(productId.toInt(), name.value, amount.value.toInt()))
            }
        }
    }

}
