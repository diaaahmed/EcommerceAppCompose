package com.compose.ecommerceappcompose.di

import com.compose.NewsUsecase
import com.compose.ecommerceappcompose.NewsRepo
import com.compose.ecommerceappcompose.network.IApiService
import com.compose.ecommerceappcompose.repo.NewsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule
{

    @Provides
    @Singleton
    fun provideUseCase(newsRepo: NewsRepo):NewsUsecase{
        return NewsUsecase(newsRepo)
    }

    @Provides
    @Singleton
    fun provideNewRepo(apiService: IApiService):NewsRepo{
        return NewsRepoImpl(apiService)
    }
}