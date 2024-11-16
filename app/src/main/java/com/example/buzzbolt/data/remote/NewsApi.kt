package com.example.buzzbolt.data.remote

import com.example.buzzbolt.data.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("source") sources: String,
        @Query("apiKey") apiKey: String
        ): NewsResponse
}