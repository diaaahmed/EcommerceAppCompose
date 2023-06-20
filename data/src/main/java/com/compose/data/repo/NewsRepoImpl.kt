package com.compose.data.repo

import com.compose.data.network.IApiService
import com.compose.domain.entity.NewsResponse
import com.compose.domain.repo.NewsRepo

class NewsRepoImpl(private val apiService: IApiService):NewsRepo {

    override suspend fun getNews(country:String): NewsResponse  = apiService.getArticles(country)

}