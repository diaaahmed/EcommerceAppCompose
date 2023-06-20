package com.compose.ecommerceappcompose.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.compose.NewsUsecase
import com.compose.ecommerceappcompose.entity.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor (private val usecase: NewsUsecase): ViewModel()
{
    private var errorHandler = CoroutineExceptionHandler{ _, throwable->
        Log.d(TAG, "Error here: ${throwable.message}")
    }

    private val _response:MutableLiveData<Products> = MutableLiveData()
    val response:LiveData<Products> = _response

    var state by mutableStateOf(Products())

    init{
        getNews()
    }

    private fun getNews()
    {
        viewModelScope.launch( errorHandler) {
            val response = usecase.getProducts()
            _response.value = response
            state = response
        }
    }

}