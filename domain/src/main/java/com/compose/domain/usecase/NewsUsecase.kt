package com.compose.domain.usecase

import com.compose.domain.repo.NewsRepo

class NewsUsecase(private val newsRepo: NewsRepo)
{
    suspend fun getNews(country:String) = newsRepo.getNews(country)
}