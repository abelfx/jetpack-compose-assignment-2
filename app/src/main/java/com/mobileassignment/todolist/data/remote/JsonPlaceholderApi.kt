package com.mobileassignment.todolist.data.remote

import retrofit2.http.GET

data class TodoDto(
    val id: Int,
    val title: String,
    val completed: Boolean
)

interface JsonPlaceholderApi {
    @GET("todos")
    suspend fun getTodos(): List<TodoDto>
}
