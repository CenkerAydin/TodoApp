package com.cenkeraydin.todoapp.retrofit

import com.cenkeraydin.todoapp.service.TodoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    val api: TodoAPI by lazy{
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoAPI::class.java)
    }
}