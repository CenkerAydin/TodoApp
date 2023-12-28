package com.cenkeraydin.todoapp.service

import com.cenkeraydin.todoapp.model.Todo
import retrofit2.Response

interface TodoAPI {

    fun getTodos():Response<Todo>
}