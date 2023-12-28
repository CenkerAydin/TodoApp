package com.cenkeraydin.todoapp.model

data class Todo(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId:Int
)