package com.compose.data.network

import com.compose.data.BuildConfig
import com.compose.data.endpoint.Url
import com.compose.domain.entity.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService
{

    @GET(Url.newsEndPoint)
    suspend fun getArticles(@Query("country") country:String,
                            @Query("apiKey") apiKey:String =
                                BuildConfig.API_KEY): NewsResponse
}