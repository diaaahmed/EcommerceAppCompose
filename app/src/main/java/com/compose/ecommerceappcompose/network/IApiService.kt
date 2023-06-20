package com.compose.ecommerceappcompose.network

import com.compose.ecommerceappcompose.endpoint.Url
import com.compose.ecommerceappcompose.entity.Products
import com.compose.ecommerceappcompose.entity.ProductsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService
{
    @GET(Url.newsEndPoint)
    suspend fun getArticles(): Products

    @GET(Url.newsEndPoint+"/{id}")
    suspend fun getSingleProduct(
        @Path("id") productId: Int
    ):ProductsItem
}