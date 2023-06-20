package com.compose.ecommerceappcompose.repo

import com.compose.ecommerceappcompose.NewsRepo
import com.compose.ecommerceappcompose.entity.Products
import com.compose.ecommerceappcompose.entity.ProductsItem
import com.compose.ecommerceappcompose.network.IApiService

class NewsRepoImpl(private val apiService: IApiService): NewsRepo {

    override suspend fun getProducts(): Products = apiService.getArticles()
    override suspend fun getSingleProduct(id: Int): ProductsItem = apiService.getSingleProduct(id)
}