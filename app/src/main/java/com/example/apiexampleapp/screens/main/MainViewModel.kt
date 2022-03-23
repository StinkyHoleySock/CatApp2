package com.example.apiexampleapp.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiexampleapp.data.repository.Repository
import com.example.apiexampleapp.model.Cat
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    private var repository = Repository()
    val cat: MutableLiveData<Response<List<Cat>>> = MutableLiveData()

    fun getCat() {
        viewModelScope.launch {
            cat.value = repository.getCat()
        }
    }
}

