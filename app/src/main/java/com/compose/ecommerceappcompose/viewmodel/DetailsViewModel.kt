package com.compose.ecommerceappcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.NewsUsecase
import com.compose.ecommerceappcompose.entity.ProductsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val usecase: NewsUsecase,
private val stateHandle: SavedStateHandle
): ViewModel()
{

    var state = mutableStateOf<ProductsItem?>(null)

    init{
        val productId = stateHandle.get<Int>("product_id") ?: 0


        getProduct(productId)
    }

    private fun getProduct(productId:Int)
    {
        viewModelScope.launch {
            val response = usecase.getSingleProduct(productId)
            state.value = response
        }
    }
}