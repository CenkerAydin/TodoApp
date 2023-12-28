package com.cenkeraydin.todoapp.service

import com.cenkeraydin.todoapp.model.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoAPI {

    @GET("/todos")
    suspend  fun getTodos(@Query("key") key:String):Response<List<Todo>>


}