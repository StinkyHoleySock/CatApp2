package com.example.apiexampleapp.data.repository

import com.example.apiexampleapp.data.api.RetrofitInstance
import com.example.apiexampleapp.model.Cat
import retrofit2.Response

class Repository {

    suspend fun getCat(): Response<List<Cat>> {
        return RetrofitInstance.api.getCat()
    }
}