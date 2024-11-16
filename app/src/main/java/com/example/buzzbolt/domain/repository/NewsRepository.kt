package com.example.buzzbolt.domain.repository

import com.example.buzzbolt.data.dto.NewsResponse
import retrofit2.Response

interface NewsRepository {
    fun getNews(sources: List<String>): Response<NewsResponse>
}