package com.compose.domain.repo

import com.compose.domain.entity.NewsResponse

interface NewsRepo
{
    suspend fun getNews(country:String):NewsResponse
}