package com.compose.ecommerceappcompose

import com.compose.ecommerceappcompose.entity.Products
import com.compose.ecommerceappcompose.entity.ProductsItem


interface NewsRepo
{
    suspend fun getProducts(): Products

    suspend fun getSingleProduct(id:Int): ProductsItem
}