package com.mobileassignment.todolist.data.repository

import com.mobileassignment.todolist.data.local.dao.TodoDao
import com.mobileassignment.todolist.data.local.entity.TodoEntity
import com.mobileassignment.todolist.data.remote.JsonPlaceholderApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoRepository(
    private val api: JsonPlaceholderApi,
    private val dao: TodoDao
) {
    fun getTodos(): Flow<List<TodoEntity>> = flow {
        // Emit cached todos first
        val cachedTodos = dao.getTodos()
        emit(cachedTodos)

        try {
            // Fetch from API
            val remoteTodos = api.getTodos()
            val entities = remoteTodos.map { TodoEntity(it.id, it.title, it.completed) }
            // Cache in database
            dao.insertAll(entities)
            // Emit updated todos
            emit(entities)
        } catch (e: Exception) {
            // Log error or handle it
            e.printStackTrace()
            // Optionally emit cached again or do nothing
        }
    }

    suspend fun getTodoById(id: Int): TodoEntity? {
        return dao.getTodos().find { it.id == id }
    }
}
