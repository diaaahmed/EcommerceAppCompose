package com.compose

import com.compose.ecommerceappcompose.NewsRepo


class NewsUsecase(private val newsRepo: NewsRepo)
{
    suspend fun getProducts() = newsRepo.getProducts()

    suspend fun getSingleProduct(id:Int) = newsRepo.getSingleProduct(id)
}