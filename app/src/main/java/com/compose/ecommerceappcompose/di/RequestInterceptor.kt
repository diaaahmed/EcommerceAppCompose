package com.compose.ecommerceappcompose.di

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class RequestInterceptor: Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url =
            originalUrl.newBuilder() //.addQueryParameter("api_key", AppConstants.TMDB_API_KEY)
                .build()

        val requestBuilder: Request.Builder = originalRequest.newBuilder().url(url)
        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}