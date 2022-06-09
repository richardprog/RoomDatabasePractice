package com.example.roomdatabasepractice.presentation.product_list

import com.example.roomdatabasepractice.data.entity.Product

sealed class ProductListEvent {
    data class OnNameChanged(val value : String) : ProductListEvent()
    data class OnDescriptionChanged(val value : String) : ProductListEvent()
    data class OnTypeChanged(val value : String) : ProductListEvent()
    object OnClickInsertProductButton : ProductListEvent()
    object OnClickDeleteAllProductsButton : ProductListEvent()
    data class OnClickUpdateProductButton(val product : Product) : ProductListEvent()
    data class OnClickDeleteProductButton(val product : Product) : ProductListEvent()
}
