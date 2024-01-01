package com.cenkeraydin.todoapp.service

import com.cenkeraydin.todoapp.model.Todo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface TodoAPI {

    @GET("/todos")
    fun getTodos(): Call<List<Todo>>


}