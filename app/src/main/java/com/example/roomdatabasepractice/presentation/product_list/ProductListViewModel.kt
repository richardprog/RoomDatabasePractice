package com.example.roomdatabasepractice.presentation.product_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasepractice.data.entity.Product
import com.example.roomdatabasepractice.data.repository.ProductRepository
import com.example.roomdatabasepractice.presentation.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository
)  : ViewModel() {
    var productList = repository.getAllProducts()
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var name by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set
    var type by mutableStateOf("")
        private set

    fun onEvent(event: ProductListEvent) {
        when (event) {
            is ProductListEvent.OnNameChanged -> {
                name = event.value
            }
            is ProductListEvent.OnDescriptionChanged -> {
                description = event.value
            }
            is ProductListEvent.OnTypeChanged -> {
                type = event.value
            }
            is ProductListEvent.OnClickInsertProductButton -> {
                viewModelScope.launch {
                    repository.insertProduct(
                        Product(
                            name = name,
                            description = description,
                            type = type
                        )
                    )
                    productList = repository.getAllProducts()
                    name = ""
                    description = ""
                    type = ""
                    sendUiEvent(
                        UiEvent.ShowSnackbar(
                        message = "New product has been inserted"
                    ))
                }
            }
            is ProductListEvent.OnClickDeleteAllProductsButton -> {
                viewModelScope.launch {
                    repository.deleteAllProducts()
                    productList = repository.getAllProducts()
                    sendUiEvent(
                        UiEvent.ShowSnackbar(
                        message = "All products have been deleted"
                    ))
                }
            }
            is ProductListEvent.OnClickUpdateProductButton -> {
                viewModelScope.launch {
                    repository.updateProduct(event.product.copy(
                        name = name,
                        description = description,
                        type = type
                    ))
                    productList = repository.getAllProducts()
                    name = ""
                    description = ""
                    type = ""
                    sendUiEvent(
                        UiEvent.ShowSnackbar(
                        message = "Selected product has been updated with new details"
                    ))
                }
            }
            is ProductListEvent.OnClickDeleteProductButton -> {
                viewModelScope.launch {
                    repository.deleteProduct(event.product)
                    productList = repository.getAllProducts()
                    sendUiEvent(
                        UiEvent.ShowSnackbar(
                        message = "Selected product has been deleted"
                    ))
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}