package com.example.apiexampleapp.data.api

import com.example.apiexampleapp.model.Cat
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/images/search")
    suspend fun getCat(): Response<List<Cat>>
}